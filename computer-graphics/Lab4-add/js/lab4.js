var scene = new THREE.Scene();
var camera = new THREE.PerspectiveCamera(75, window.innerWidth/window.innerHeight, 0.1, 1000);

var renderer = new THREE.WebGLRenderer();
renderer.setSize(window.innerWidth, window.innerHeight);
renderer.shadowMap.enabled = true;
renderer.shadowMap.type = THREE.PCFSoftShadowMap;
document.body.appendChild(renderer.domElement);

controls = new THREE.OrbitControls(camera);

//ambient light
var light = new THREE.AmbientLight(0x404040);
scene.add(light);

//main light
var mainLight = new THREE.DirectionalLight(0xffffff, 0.75);
mainLight.castShadow = true;
scene.add(mainLight);
 var helper = new THREE.DirectionalLightHelper(mainLight, 5);
 scene.add(helper);

//textures
var loader;
var textureDiffuse; 
var textureBump;
var textureNormal;            
loader = new THREE.TextureLoader();
textureDiffuse = loader.load("textures/texture_second.jpg");
textureSphere = loader.load("textures/texture_first.jpg");
textureTeapot = loader.load("textures/texture_second.jpg");

var geometry;
var material;

//ground
geometry = new THREE.PlaneGeometry(12, 12, 12);
material = new THREE.MeshLambertMaterial({
    color: 0xcecece
});
var ground = new THREE.Mesh(geometry, material);
ground.rotation.x = Math.PI / -2;
ground.receiveShadow = true;
scene.add(ground);

//sphere
geometry = new THREE.SphereGeometry(0.7, 32, 32);
material = new THREE.MeshPhongMaterial({
    map: textureSphere,
    shininess: 80,
});
var sphere = new THREE.Mesh(geometry, material);
sphere.castShadow = true;
sphere.position.y = 0.7;
sphere.position.x = -3;
scene.add(sphere);

//dodecahedron
geometry = new THREE.DodecahedronBufferGeometry(0.7, 0);
material = new THREE.MeshPhongMaterial({
    map: textureDiffuse,
    side: THREE.DoubleSide,
    transparent: true,
    opacity: 0.3
});
var dodecahedron = new THREE.Mesh(geometry, material);
dodecahedron.castShadow = true;
dodecahedron.position.y = 0.7;
dodecahedron.position.x = 0;
scene.add(dodecahedron);

//teapot
// Load Object
var teapot;
var material = new THREE.MeshPhongMaterial({map: textureTeapot});
var loader = new THREE.OBJLoader();
loader.load('obj/teapot.obj', function(object) {
            
            object.scale.x = 3;
            object.scale.y = 3;
            object.scale.z = 3;
            object.name = 'teapot';
            // size
            object.scale.set( 1, 1, 1 );
  
            scene.add(object);
            
            teapot = scene.getObjectByName('teapot');
            teapot.children[0].material = material;
            // x and y
            teapot.position.y = 0;
            teapot.position.x = 3;
            
            // shadow
            teapot = object.children[0];
            teapot.castShadow = true;
            teapot.receiveShadow = true;
            
            });

// callback after the file is loaded
function addModelToScene ( geometry, materials )
{
    var material = new THREE.MeshFaceMaterial (materials);
    jsonModel = new THREE.Mesh (geometry, material);
    jsonModel.scale.set (4,4,4);
    scene.add (jsonModel);
}

camera.position.set(0, 5, 5);
camera.rotation.x = Math.PI / -6;

var r = 25.0;
var t;
var lx;
var lz;
var red = 1.0;
var green = 1.0;
var blue = 1.0;
var moreIntensity = true;

var render = function () {
    requestAnimationFrame(render);

    //change position
    t = (Date.now() / 5000);
    lx = r * Math.cos(t);
    lz = r * Math.sin(t);
    mainLight.position.set(lx, 20, lz);

    //change color
    if (lx > 0 && lz > 0) {
        red = (red < 1.0) ? red + 0.01 : 1.0;
        green = (green > 0.0) ? green - 0.01 : 0.0;
        blue = (blue > 0.0) ? blue - 0.01 : 0.0;
    } else if (lx > 0 && lz < 0) {
        red = (red > 0.0) ? red - 0.01 : 0.0;
        green = (green < 1.0) ? green + 0.01 : 1.0;
        blue = (blue > 0.0) ? blue - 0.01 : 0.0;
    } else if (lx < 0 && lz < 0) {
        red = (red > 0.0) ? red - 0.01 : 0.0;
        green = (green > 0.0) ? green - 0.01 : 0.0;
        blue = (blue < 1.0) ? blue + 0.01 : 1.0;
    } else {
        red = (red < 1.0) ? red + 0.01 : 1.0;
        green = (green < 1.0) ? green + 0.01 : 1.0;
        blue = (blue < 1.0) ? blue + 0.01 : 1.0;
    }

    mainLight.color.setRGB(red, green, blue);

    controls.update();
    renderer.render(scene, camera);
};

render();

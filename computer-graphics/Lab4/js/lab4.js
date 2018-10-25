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

//textures
var loader;
var textureDiffuse; 
var textureBump;
var textureNormal;            
loader = new THREE.TextureLoader();
textureDiffuse = loader.load("textures/texture_cube.jpg");
textureSphere = loader.load("textures/texture_sphere.jpg");
textureCone = loader.load("textures/texture_cone.jpg");

var geometry;
var material;

//ground
geometry = new THREE.PlaneGeometry(20, 20, 20);
material = new THREE.MeshLambertMaterial({
    color: 0xcecece
});
var ground = new THREE.Mesh(geometry, material);
ground.rotation.x = Math.PI / -2;
ground.receiveShadow = true;
scene.add(ground);

//sphere
geometry = new THREE.SphereGeometry(1, 32, 32);
material = new THREE.MeshPhongMaterial({
    map: textureSphere,
    shininess: 80,
});
var sphere = new THREE.Mesh(geometry, material);
sphere.castShadow = true;
sphere.position.y = 1;
sphere.position.x = -4;
scene.add(sphere);

//cube
geometry = new THREE.BoxGeometry(1.5, 1.5, 1.5);
material = new THREE.MeshPhongMaterial({
    map: textureDiffuse,
    side: THREE.DoubleSide,
    transparent: true,
    opacity: 0.8
});
var cube = new THREE.Mesh(geometry, material);
cube.castShadow = true;
cube.position.y = 0.5;
cube.position.x = 0;
scene.add(cube);

//cone
geometry = new THREE.CylinderGeometry(0, 1, 2, 160);
material = new THREE.MeshPhongMaterial({
    map: textureCone,
});
var cone = new THREE.Mesh(geometry, material);
cone.castShadow = true;
cone.position.y = 1;
cone.position.x = 4;
scene.add(cone);

camera.position.set(0, 5, 10);
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

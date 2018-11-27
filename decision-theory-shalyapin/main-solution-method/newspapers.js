test = {
   data: [
       {
           title: "Смена",
           k1: 0.008,
           k2: 0.100,
           k3: 0.500,
           k4: 44000,
           k5: 500,
           k6: 2800000,
           k7: 0.3,
           k8: 30
       },
       {
           title: "Час Пик",
           k1: 0.010,
           k2: 0.0625,
           k3: 0.125,
           k4: 70000,
           k5: 700,
           k6: 3000000,
           k7: 0.8,
           k8: 45
       },
       {
           title: "Невское время",
           k1: 0.010,
           k2: 0.1111,
           k3: 0.200,
           k4: 47000,
           k5: 500,
           k6: 2550000,
           k7: 0.2,
           k8: 19
       },
       {
           title: "Вечерний Пб",
           k1: 0.010,
           k2: 0.1250,
           k3: 0.050,
           k4: 497000,
           k5: 600,
           k6: 2600000,
           k7: 0.6,
           k8: 20
       },
       {
           title: "СПб Ведомости",
           k1: 0.008,
           k2: 0.2000,
           k3: 0.143,
           k4: 45000,
           k5: 400,
           k6: 2500000,
           k7: 0.3,
           k8: 13
       },
       {
           title: "Деловой Пб",
           k1: 0.003,
           k2: 0.2500,
           k3: 0.167,
           k4: 80000,
           k5: 600,
           k6: 3300000,
           k7: 0.1,
           k8: 92
       },
       {
           title: "Реклама - Шанс",
           k1: 0.001,
           k2: 0.7500,
           k3: 0.038,
           k4: 85000,
           k5: 600,
           k6: 2500000,
           k7: 0.9,
           k8: 11
       },
   ],
   mainK: "k1",
   takeMainK: function(obj, mainKs) {
       return obj[this.mainK] === Math.max(...mainKs);
   },
   compare: (obj) =>
       obj.k1 >= 0.010 &&
       obj.k2 >= 0.1000 &&
       obj.k3 >= 0.038 &&
       obj.k4 >= 44000 &&
       obj.k5 >= 400 &&
       obj.k6 >= 2500000 &&
       obj.k7 >= 0.3 &&
       obj.k8 >= 10
};

function lab1(lab1Obj) {
   let tempResult = [];
   let result = [];
   let mainKs = [];

   lab1Obj.data.forEach((item) => {
       if (lab1Obj.compare(item)) tempResult.push(item);
   });

   tempResult.forEach(item => {
       mainKs.push(item[lab1Obj.mainK]);
   });

   tempResult.forEach(item => {
       if (lab1Obj.takeMainK(item, mainKs)) result.push(item);
   });

   // console.log(tempResult);
   // console.log(result);
   console.log("Главный критерий: " + lab1Obj.mainK);
   result.forEach(item => console.log(item.title + "\n"));
}

lab1(test);

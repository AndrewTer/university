my = {
   data: [
       {
           title: "Эрмитаж",
           k1: 1764,
           k2: 3000000,
           k3: 365,
           k4: 3668031,
           k5: 5,
           k6: 4.5,
           k7: 0
       },
       {
           title: "Русский музей",
           k1: 1895,
           k2: 410945,
           k3: 111,
           k4: 1566500,
           k5: 5,
           k6: 5.0,
           k7: 170
       },
       {
           title: "Эрарта",
           k1: 2010,
           k2: 2800,
           k3: 8,
           k4: 220000,
           k5: 1,
           k6: 4.6,
           k7: 500
       },
       {
           title: "Музей истории религии",
           k1: 1932,
           k2: 180000,
           k3: 12,
           k4: 655200,
           k5: 1,
           k6: 4.9,
           k7: 100
       },
       {
           title: "Кунсткамера",
           k1: 1714,
           k2: 1000000,
           k3: 15,
           k4: 957828,
           k5: 1,
           k6: 4.4,
           k7: 100
       },
       {
           title: "Зоологический музей",
           k1: 1832,
           k2: 30000,
           k3: 3,
           k4: 823920,
           k5: 1,
           k6: 4.8,
           k7: 150
       },
       {
           title: "Государственный музей истории Санкт-Петербурга",
           k1: 1924,
           k2: 1300000,
           k3: 5,
           k4: 2639841,
           k5: 1,
           k6: 4.9,
           k7: 350
       },
   ],
   mainK: "k6",
   takeMainK: function(obj, mainKs) {
       return obj[this.mainK] === Math.max(...mainKs);
   },
   compare: (obj) =>
       obj.k1 >= 1750 &&
       obj.k2 >= 500000 &&
       obj.k3 >= 5 &&
       obj.k4 >= 1000000 &&
       obj.k5 >= 1 &&
       obj.k6 >= 4.5 &&
       obj.k7 >= 0
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

lab1(my);

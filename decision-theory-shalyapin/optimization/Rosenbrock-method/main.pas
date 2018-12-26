program optimization;
uses Math; 
const
  eps = 0.000001; { Точность определения минимума }
  alfa  = 1.0;    { Коэффициент отражения         }
  beta  = 0.5;    { Коэффициент сжатия            }
  gamma = 2.0;    { Коэффициент растяжения        }
  t = 0.2;
  n_max = 6;      { Макс. количество переменных }

var
  x, y: array[0 .. n_max] of double;
  fh, fl, f4, f5, f6: double;
  h, l, it: integer;

{ *** Оптимизируемые функции *** }
//Квадратичная функция простой структуры
{function f(k: integer): double;
var r1, r2: double;
begin
  r1 := 5; r2 := 5;
  f := Power((r1-r2),2)+Power((r1+r2-10),2)/9;
end;
}

//Функция Розенброка
{function f(k: integer): double;
var r1, r2: double;
begin
  r1 := 1; r2 := 1;
  f := 100*Power((Power(r1,2)-r2),2)+Power((1-r1),2);
end;
}

//Ассиметричная долина
{function f(k: integer): double;
var r1, r2: double;
begin
  r1 := 3; r2 := 2.850214;
  f := Power(((r1-3)/100),2)-(r2-r1)+Exp(20*(r2-r1));
end;
}
 
//Функция Пауэлла
{function f(k: integer): double;
var r1, r2, r3, r4: double;
begin
  r1 := 0; r2 := 0; r3 := 0; r4 := 0;
  f := Power((r1+10*Power(r2,2)),2)+5*Power((r3-r4),2)+Power((r2-2*r3),4)+10*Power((r1-r4),4);
end;
}

//Метод наименьших квадратов
function f(k: integer): double;
var r1, r2, r3, r4, m, sum: double;
a: array [1 .. 7] of double;
b: array [1 .. 7] of double; 
i: integer;
begin
  m:=0;
  m:= 1/Power(10,3);
  a[1] := m*0;
  a[2] := m*0.428;
  a[3] := m*1;
  a[4] := m*1.61;
  a[5] := m*2.09;
  a[6] := m*3.48;
  a[7] := m*5.25;
  
  b[1] := 7.391;
  b[2] := 11.18;
  b[3] := 16.44;
  b[4] := 16.20;
  b[5] := 22.2;
  b[6] := 24.02;
  b[7] := 31.32;
  
  sum := 0;
  r1 := 2.714; r2 := 140.4; r3 := 1707; r4 := 31.51;
  
  for i:=1 to 7 do begin
    sum:=sum+Power((((Power(r1,2)+Power(r2,2)*a[i]+Power(r3,2)*Power(a[i],2))/(1+Power(r4,2)*a[i]))-b[i])/b[i],2)
  end;
  f := Power(10,4)*sum;
end;
 
function maxf: double;
var f1, f2, r: double;
begin
  f1 := f(1); f2 := f(2); r := f(0);
  h := 0;
  if r < f1 then begin
    r := f1; h := 1;
  end;
  if r < f2 then begin
    r := f2; h := 2;
  end;
  maxf := r;
end;

function minf: double;
var f1, f2, r: double;
begin
  f1 := f(1); f2 := f(2); r := f(0);
  l := 0;
  if f1 < r then begin
    r := f1; l := 1;
  end;
  if f2 < r then begin
    r := f2; l := 2;
  end;
  minf := r;
end;
 
label TheEnd;
var
  i, flag: integer;
  r, r1, x0, y0, x1, y1: double;
begin
    x0 := -1.2; y0 := 1;
    x[0] := x0-0.5*t; y[0] := y0-t*sqrt(3)/6;
    x[1] := x0; y[1] := y0; r := f(1); y[1] := y0+t*sqrt(3)/3;
    x[2] := x0+0.5*t; y[2] := y[0];
 
    it := 0;
    writeln(' Итерация: ', it:5, ' x=', x0:8:4, ' y=', y0:8:4, ' f=', r:8:4);
    repeat
        fh := maxf; fl := minf;
        x[3] := 0.5*(x[0]+x[1]+x[2]-x[h]);
        y[3] := 0.5*(y[0]+y[1]+y[2]-y[h]);
 
        x[4] := (1+alfa)*x[3]-alfa*x[h];
        y[4] := (1+alfa)*y[3]-alfa*y[h];

        f4 := f(4);
        if (f4 < fl) then begin
            x[5]:=(1-gamma)*x[3]+gamma*x[4];
            y[5]:=(1-gamma)*y[3]+gamma*y[4];
            f5:=f(5);
            if (f5 < fl) then begin x[h]:=x[5]; y[h]:=y[5]; end
            else begin x[h]:=x[4]; y[h]:=y[4]; end;
            goto TheEnd;
        end;
 
        flag := 0;
        for i := 0 to pred(3) do begin
          if ((i <> h) and (f4 > f(i))) then inc(flag);
        end;
        if (flag = 2) then begin
            x[6]:=beta*x[h]+(1-beta)*x[3]; y[6]:=beta*y[h]+(1-beta)*y[3];
            x[h]:=x[6]; y[h]:=y[6];
 
            goto TheEnd;
        end;
 
        if (f(4) < fh) then begin
            for i := 0 to pred(3) do begin
              x[i]:=0.5*(x[i]+x[l]); y[i]:=0.5*(y[i]+y[l]);
            end;
        end
        else begin
            x[h]:=x[4]; y[h]:=y[4];
        end;
 
        TheEnd:;
        r := 0;
        for i := 0 to pred(3) do begin
          r1 := f(i)-f(3); r := r + r1*r1;
        end;
        r:=sqrt(r/3);
        inc(it);
 
        r1:=(f(0)+f(1)+f(2))/3;
        x0:=(x[0]+x[1]+x[2])/3;
        y0:=(y[0]+y[1]+y[2])/3;
 
        if it mod 20 = 0 then
          writeln(' Итерация: ', it:5, ' x=', x0:8:4, ' y=', y0:8:4, ' f=', r:8:4);
    until (r < eps);
 
    writeln(' Итерация: ', it:5, ' x=', x0:8:4, ' y=', y0:8:4, ' f=', r:8:4);
end.

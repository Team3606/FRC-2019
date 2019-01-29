#include <Arduino

void setup() {
  Serial.begin(9600);
}

void loop() {

  //x is the x vlue 
  //y is the y value
  //z is the confidence value
  
  int x =0,y=0,z=0;
  Serial.println(char(199) + Stringx(x) + char(123)+ Stringx(y) + char(123)+ Stringx(z));
}

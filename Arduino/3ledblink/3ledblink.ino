void setup() {
  // put your setup code here, to run once:
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:

  // pin 9
  for(int i = 0; i<256; i++)
  {
    analogWrite(9, i);
    delay(5);
  }
  for(int i = 255; i>=0; i--)
  {
    analogWrite(9, i);
    delay(5);
  }

  // pin 10
  for(int i = 0; i<256; i++)
  {
    analogWrite(10, i);
    delay(5);
  }
  for(int i = 255; i>=0; i--){
    analogWrite(10, i);
    delay(5);
  }
  
  // pin 11
  for(int i = 0; i<256; i++)
  {
    analogWrite(11, i);
    delay(5);
  }
  for(int i = 255; i>=0; i--){
    analogWrite(11, i);
    delay(5);
  }
}

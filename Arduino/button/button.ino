int pushbutton = A0;
int value = 0;
int counter = 0;


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(pushbutton, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  value = digitalRead(pushbutton);
  
  if(value > 0){
    Serial.print("Counter: ");
    counter++;
    Serial.println(counter);
    
    while(value==1){
      value = digitalRead(pushbutton);
      delay(1);
    }
  }
  
  delay(10);
}

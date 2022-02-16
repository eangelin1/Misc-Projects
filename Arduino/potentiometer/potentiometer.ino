int analogPin = A0;
int analogPin2 = A1;
int input_value = 0;
int input_value2 = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(analogPin, INPUT);
  pinMode(analogPin2, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  input_value = analogRead(analogPin);
  Serial.print("Input 1: ");
  Serial.println(input_value);
  delay(100);
  
  input_value2 = analogRead(analogPin2);
  Serial.print("Input 2: ");
  Serial.println(input_value2);
  delay(100);
}

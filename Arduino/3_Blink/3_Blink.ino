void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(11, OUTPUT);
  pinMode(12, OUTPUT);
  pinMode(13, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:

  digitalWrite(11, HIGH);
  delay(1000);
  Serial.println("LED 1 ON");
  digitalWrite(11, LOW);
  Serial.println("LED 1 OFF");
  

  digitalWrite(12, HIGH);
  delay(500);
  Serial.println("LED 2 ON");
  digitalWrite(12, LOW);
  Serial.println("LED 2 OFF");

  digitalWrite(13, HIGH);
  delay(750);
  Serial.println("LED 3 ON");
  digitalWrite(13, LOW);
  Serial.println("LED 3 OFF");

}

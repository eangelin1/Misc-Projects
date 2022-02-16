int R = 10;
int G = 9;
int B = 11;
int R_in = A5;
int R_value;

void setup() {
  // put your setup code here, to run once:
  pinMode(R, OUTPUT);
  pinMode(G, OUTPUT);
  pinMode(B, OUTPUT);
  pinMode(R_in, INPUT);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  analogWrite(R, 255);
  R_value = analogRead(R_in);
  Serial.print("Value of Red = ");
  Serial.println(R_value/4);
  
  delay(500);
  analogWrite(R, 0);
  
  analogWrite(G, 255);
  Serial.println("Value of Green = 255");
  delay(500);
  analogWrite(G, 0);
  
  analogWrite(B, 255);
  Serial.println("Value of Blue = 255");
  delay(500);
  analogWrite(B, 0);
  
  
}

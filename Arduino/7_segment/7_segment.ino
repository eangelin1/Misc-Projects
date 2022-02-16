int mysize = 8;
int pins[8] = {2,3,4,5,6,7,8,9};

void setup() {
  // put your setup code here, to run once:
  pinMode(pins, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  // test all segments

  for(int i = 0; i<mysize; i++){
    digitalWrite(pins[i], HIGH);
  }
  delay(1000);

  for(int i = 0; i<mysize; i++){
    digitalWrite(pins[i], LOW);
  }
  delay(1000);

  int one[] = {4,6};
  int two[] = {5,4,3,9,8};
  int three[] = {5,4,3,6,8};
  int four[] = {2,3,4,6};
  int five[] = {5,2,3,6,8};
  int six[] = {5,2,3,6,8,9};
  int seven[] = {5,4,6};
  int eight[] = {2,3,4,5,6,8,9};
  int nine[] = {5,2,3,4,6};

  // one
  for(int i = 0; i<sizeof(one)/sizeof(3); i++){
    digitalWrite(one[i], HIGH);
  }
  delay(1000);
  for(int i = 0; i<sizeof(one)/sizeof(3); i++){
    digitalWrite(one[i], LOW);
  }
  delay(1000);

  // two
  for(int i = 0; i<sizeof(two)/sizeof(3); i++){
    digitalWrite(two[i], HIGH);
  }
  delay(1000);
  
  for(int i = 0; i<sizeof(two)/sizeof(3); i++){
    digitalWrite(two[i], LOW);
  }
  delay(1000);

  // three
  for(int i = 0; i<sizeof(three)/sizeof(3); i++){
    digitalWrite(three[i], HIGH);
  }
  delay(1000);
  
  for(int i = 0; i<sizeof(three)/sizeof(3); i++){
    digitalWrite(three[i], LOW);
  }
  delay(1000);

  // four
  
  for(int i = 0; i<sizeof(four)/sizeof(3); i++){
    digitalWrite(four[i], HIGH);
  }
  delay(1000);
  for(int i = 0; i<sizeof(four)/sizeof(3); i++){
    digitalWrite(four[i], LOW);
  }
  delay(1000);

  // five
  
  for(int i = 0; i<sizeof(five)/sizeof(3); i++){
    digitalWrite(five[i], HIGH);
  }
  delay(1000);
  for(int i = 0; i<sizeof(five)/sizeof(3); i++){
    digitalWrite(five[i], LOW);
  }
  delay(1000);

  // six

  for(int i = 0; i<sizeof(six)/sizeof(3); i++){
    digitalWrite(six[i], HIGH);
  }
  delay(1000);
  for(int i = 0; i<sizeof(six)/sizeof(3); i++){
    digitalWrite(six[i], LOW);
  }
  delay(1000);

  // seven
  
  for(int i = 0; i<sizeof(seven)/sizeof(3); i++){
    digitalWrite(seven[i], HIGH);
  }
  delay(1000);
  for(int i = 0; i<sizeof(seven)/sizeof(3); i++){
    digitalWrite(seven[i], LOW);
  }
  delay(1000);

  // eight

  
  for(int i = 0; i<sizeof(eight)/sizeof(3); i++){
    digitalWrite(eight[i], HIGH);
  }
  delay(1000);
  for(int i = 0; i<sizeof(eight)/sizeof(3); i++){
    digitalWrite(eight[i], LOW);
  }
  delay(1000);

  // nine
  
  for(int i = 0; i<sizeof(nine)/sizeof(3); i++){
    digitalWrite(nine[i], HIGH);
  }
  delay(1000);
  for(int i = 0; i<sizeof(nine)/sizeof(3); i++){
    digitalWrite(nine[i], LOW);
  }
  delay(1000);
  
}

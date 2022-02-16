void setup() {
  // put your setup code here, to run once:
  int pins[] = {9,10,11};
  pinMode(pins, OUTPUT);
  Serial.begin(9600);
}

int green(int current_green){
  int rnum = random(256);
  Serial.println(rnum);
  if(rnum<current_green){
    while(current_green>rnum){
      analogWrite(9,current_green);
      delay(25);
      current_green--;
    }
  }
  else if(rnum>current_green){
    while(current_green<rnum){
      analogWrite(9,current_green);
      delay(25);
      current_green++;
    }
  }
  Serial.println(current_green);
  return current_green;
}

int blue(int current_blue){
  int rnum = random(256);
  Serial.println(rnum);
  if(rnum<current_blue){
    while(current_blue>rnum){
      analogWrite(10,current_blue);
      delay(25);
      current_blue--;
    }
  }
  else if(rnum>current_blue){
    while(current_blue<rnum){
      analogWrite(10,current_blue);
      delay(25);
      current_blue++;
    }
  }
  Serial.println(current_blue);
  return current_blue;
}

int red(int current_red){
  int rnum = random(256);
  Serial.println(rnum);
  if(rnum<current_red){
    while(current_red>rnum){
      analogWrite(11,current_red);
      delay(25);
      current_red--;
    }
  }
  else if(rnum>current_red){
    while(current_red<rnum){
      analogWrite(11,current_red);
      delay(25);
      current_red++;
    }
  }
  Serial.println(current_red);
  return current_red;
}

void loop() {
  // put your main code here, to run repeatedly:

  int current_red = 0;
  int current_blue = 0;
  int current_green = 0;
  int i=0;
  
  while(i<50000){
    int rnum = random(3);

    if(rnum == 0){
      Serial.println("running: red");
      current_red = red(current_red);
    }
    else if(rnum == 1){
      Serial.println("running: blue");
      current_blue = blue(current_blue);
    }
    else{
      Serial.println("running: green");
      current_green = green(current_green);
    }

    // Serial.println(current_red);
    // Serial.println(current_blue);
    // Serial.println(current_green);
    
    i++;
  }

  Serial.println("done");
  
  digitalWrite(9, LOW);
  digitalWrite(10, LOW);
  digitalWrite(11, LOW); 
}

// include the library code:
#include <LiquidCrystal.h>

// initialize the library by associating any needed LCD interface pin
// with the arduino pin number it is connected to
const int rs = 12, en = 11, d4 = 5, d5 = 4, d6 = 3, d7 = 2;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);

String message = "Hello everyone";

void setup() {
  // put your setup code here, to run once:
  lcd.begin(16, 2);
  //lcd.print(message);
  //lcd.setCursor(15,0);
  //lcd.print(message);
}

void loop() {
  // put your main code here, to run repeatedly:
  
  for(int i = 15; i >= 0; i--){
    lcd.setCursor(i, 0);
    lcd.print(message);
    delay(500);
    lcd.clear();
  }
  for(int i = -9; i >= -20; i--){
    lcd.setCursor(i, 0);
    lcd.print(message);
    delay(500);
    lcd.clear();
  }
  
}

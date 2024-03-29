/*
  LiquidCrystal Library - Hello World

 Demonstrates the use a 16x2 LCD display.  The LiquidCrystal
 library works with all LCD displays that are compatible with the
 Hitachi HD44780 driver. There are many of them out there, and you
 can usually tell them by the 16-pin interface.

 This sketch prints "Hello World!" to the LCD
 and shows the time.

  The circuit:
 * LCD RS pin to digital pin 12
 * LCD Enable pin to digital pin 11
 * LCD D4 pin to digital pin 5
 * LCD D5 pin to digital pin 4
 * LCD D6 pin to digital pin 3
 * LCD D7 pin to digital pin 2
 * LCD R/W pin to ground
 * LCD VSS pin to ground
 * LCD VCC pin to 5V
 * 10K resistor:
 * ends to +5V and ground
 * wiper to LCD VO pin (pin 3)

 Library originally added 18 Apr 2008
 by David A. Mellis
 library modified 5 Jul 2009
 by Limor Fried (http://www.ladyada.net)
 example added 9 Jul 2009
 by Tom Igoe
 modified 22 Nov 2010
 by Tom Igoe
 modified 7 Nov 2016
 by Arturo Guadalupi

 This example code is in the public domain.

 http://www.arduino.cc/en/Tutorial/LiquidCrystalHelloWorld

*/

// include the library code:
#include <LiquidCrystal.h>

// initialize the library by associating any needed LCD interface pin
// with the arduino pin number it is connected to
const int rs = 12, en = 11, d4 = 5, d5 = 4, d6 = 3, d7 = 2;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);

// pin numbers for the ultrasonic sensor
// variables to calculate distance
int trigpin=6;
int echopin=7;
long duration;
int distance;

void setup() {
  // set up ultrasonic sensor
  pinMode(trigpin, OUTPUT);
  pinMode(echopin, INPUT);
  // set up serial monitor
  Serial.begin(9600);
  // set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
  // initaial message for lcd
  lcd.print("DISTANCE (IN CM)");
}

void loop() {
  // get reading from trigpin
  digitalWrite(trigpin, LOW);
  delayMicroseconds(5);
  digitalWrite(trigpin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigpin, LOW);

  // calculate distance and print to lcd display
  duration = pulseIn(echopin, HIGH);
  distance = duration * .034 /2;
  Serial.print(distance);
  Serial.println(" cm");

  // print to lcd
  lcd.setCursor(0, 1);
  // print the number of seconds since reset:
  lcd.print(distance);
  delay(50);
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("DISTANCE (IN CM)");
}

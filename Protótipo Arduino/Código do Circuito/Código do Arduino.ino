#include <LiquidCrystal.h>

// Definindo os pinos dos sensores
int tempPin = A0;      // TMP36 no A0
int umidPin = A1;      // Soil Moisture Sensor no A1
int luzPin = A2;       // Sensor de Luminosidade no A2

// Configurando o LCD (RS, E, D4, D5, D6, D7) - ajuste se usou outros pinos
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

void setup() {
  Serial.begin(9600);
  lcd.begin(16, 2);  // Inicializa o LCD 16x2
  lcd.clear();
}

void loop() {
  // Leitura da temperatura
  int tempValue = analogRead(tempPin);
  float tempCelsius = (tempValue * (5.0 / 1023.0) - 0.5) * 100;

  // Leitura da umidade
  int umidValue = analogRead(umidPin);
  int umidade = map(umidValue, 0, 1023, 0, 100);

  // Leitura da luminosidade
  int luzValue = analogRead(luzPin);
  int luminosidade = map(luzValue, 0, 1023, 0, 100);
  String statusLuz = (luminosidade > 50) ? "Ligada" : "Desligada";

  // Exibindo no Monitor Serial
  Serial.print("Temperatura: ");
  Serial.print(tempCelsius, 1);
  Serial.println(" *C");

  Serial.print("Umidade: ");
  Serial.print(umidade);
  Serial.println("%");

  Serial.print("Luminosidade: ");
  Serial.print(luminosidade);
  Serial.print("% - Luz ");
  Serial.println(statusLuz);

  Serial.println();  // Pula linha

  // Exibindo no LCD
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("T: ");
  lcd.print(tempCelsius, 1);
  lcd.print("C ");
  lcd.print("U: ");
  lcd.print(umidade);
  lcd.print("%");

  lcd.setCursor(0, 1);
  lcd.print("L: ");
  lcd.print(luminosidade);
  lcd.print("% ");
  lcd.print(statusLuz);

  delay(2000);  // Aguarda 2 segundos
}

package com.example.client;

import com.example.calculator.Calculator;
import com.example.calculator.CalculatorSoap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Scanner;

public class CalculatorClient {

    public static void main(String[] args) {
        try {
            // Dirección del WSDL del servicio
            URL wsdlURL = new URL("http://www.dneonline.com/calculator.asmx?WSDL");
            Service service = Service.create(wsdlURL, new QName("http://tempuri.org/", "Calculator"));

            // Crear el cliente de SOAP
            CalculatorSoap calculatorSoap = service.getPort(CalculatorSoap.class);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nCalculadora SOAP");
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar");
                System.out.println("4. Dividir");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");

                int choice = scanner.nextInt();

                if (choice == 5) {
                    System.out.println("¡Gracias por usar la calculadora!");
                    break;
                }

                if (choice >= 1 && choice <= 4) {
                    System.out.print("Ingresa el primer número: ");
                    int num1 = scanner.nextInt();

                    System.out.print("Ingresa el segundo número: ");
                    int num2 = scanner.nextInt();

                    try {
                        int result = 0;
                        switch (choice) {
                            case 1: result = calculatorSoap.add(num1, num2); break;
                            case 2: result = calculatorSoap.subtract(num1, num2); break;
                            case 3: result = calculatorSoap.multiply(num1, num2); break;
                            case 4: result = calculatorSoap.divide(num1, num2); break;
                        }
                        System.out.println("Resultado: " + result);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } else {
                    System.out.println("Opción no válida.");
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

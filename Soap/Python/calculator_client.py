from zeep import Client

# SOAP
client = Client('http://www.dneonline.com/calculator.asmx?WSDL')

def main():
    while True:
        print("\nCalculadora SOAP")
        print("1. Sumar")
        print("2. Restar")
        print("3. Multiplicar")
        print("4. Dividir")
        print("5. Salir")
        choice = int(input("Elige una opción: "))

        if choice == 5:
            print("¡Gracias por usar la calculadora!")
            break

        if choice >= 1 and choice <= 4:
            num1 = int(input("Ingresa el primer número: "))
            num2 = int(input("Ingresa el segundo número: "))

            try:
                if choice == 1:
                    result = client.service.Add(num1, num2)
                elif choice == 2:
                    result = client.service.Subtract(num1, num2)
                elif choice == 3:
                    result = client.service.Multiply(num1, num2)
                elif choice == 4:
                    result = client.service.Divide(num1, num2) if num2 != 0 else "Error: División por cero."
                print(f"Resultado: {result}")
            except Exception as e:
                print(f"Error: {e}")

if __name__ == "__main__":
    main()

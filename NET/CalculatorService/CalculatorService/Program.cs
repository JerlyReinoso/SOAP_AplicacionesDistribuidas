using CalculatorService.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace CalculatorService
{
    class Program
    {
        static void Main(string[] args)
        {
            CalculatorSoapClient client = new CalculatorSoapClient();
            int choice, num1, num2, result = 0;

            do
            {
                Console.WriteLine("Calculadora SOAP");
                Console.WriteLine("1. Sumar");
                Console.WriteLine("2. Restar");
                Console.WriteLine("3. Multiplicar");
                Console.WriteLine("4. Dividir");
                Console.WriteLine("5. Salir");
                Console.Write("Elige una opción: ");
                choice = int.Parse(Console.ReadLine());

                if (choice >= 1 && choice <= 4)
                {
                    Console.Write("Ingresa el primer número: ");
                    num1 = int.Parse(Console.ReadLine());
                    Console.Write("Ingresa el segundo número: ");
                    num2 = int.Parse(Console.ReadLine());

                    switch (choice)
                    {
                        case 1:
                            result = client.Add(num1, num2);
                            Console.WriteLine($"Resultado: {result}");
                            break;
                        case 2:
                            result = client.Subtract(num1, num2);
                            Console.WriteLine($"Resultado: {result}");
                            break;
                        case 3:
                            result = client.Multiply(num1, num2);
                            Console.WriteLine($"Resultado: {result}");
                            break;
                        case 4:
                            if (num2 != 0)
                            {
                                result = client.Divide(num1, num2);
                                Console.WriteLine($"Resultado: {result}");
                            }
                            else
                            {
                                Console.WriteLine("Error: División por cero.");
                            }
                            break;
                    }
                }
            } while (choice != 5);

            client.Close();
            Console.WriteLine("¡Gracias por usar la calculadora!");
        }
    }
}

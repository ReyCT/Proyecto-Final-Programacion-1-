import java.util.ArrayList;
import java.util.Scanner;

public class proyecto
{
    //esta lista de counts llevara la cuenta de cada dato de los alumnos para despues imprimirlo en el informe
    private static int countvisitas;
    private static int countmen;
    private static int countwomen;
    private static int countprepa;
    private static int countuni;
    private static int countbiblio;
    private static int countcubiculo;
    private static int countclase;

    private static boolean loop=false;

    private static Scanner scan = new Scanner(System.in);
    private static String input;

    //lista de arrays
    private static int espacio=10;
    private static ArrayList<String> matricula = new ArrayList<String>();
    private static ArrayList<String> nombre = new ArrayList<String>();
    private static ArrayList<String> genero = new ArrayList<String>();
    private static ArrayList<String> nivel = new ArrayList<String>();

    public static void main(String args[])
    {
        database();

        System.out.println("\n   Bienvenido al sistema de registro");
        System.out.println("   de ingreso de alumnos a biblioteca\n");
        System.out.println("Ingrese nombre de usuario");

        input = scan.nextLine();
        if (input.equals("admin1"))
        {

        }
        else
        {
            while (true)
            {
                System.out.println("Ingrese un nombre de usuario valido");
                input = scan.nextLine();
                if (input.equals("admin1"))
                {
                    break;
                }
                else
                {

                }
            }
        }
        System.out.println("Ingrese su contraseña");
        input = scan.nextLine();
        if (input.equals("password"))
        {
            System.out.println("Bienvenido: admin1");
            admin();
        }
        else
        {
            while (true)
            {
                System.out.println("Ingresa una contraseña valida");
                input = scan.nextLine();
                if (input.equals("password"))
                {
                    System.out.println("Bienvenido: admin1");
                    admin();
                    break;
                }
                else
                {

                }
            }
        }
    }
    public static void database()
    {
        //Matriculas predefinidas que se añadiran a la base de datos
        matricula.add("12189");
        matricula.add("12341");
        matricula.add("12342");
        matricula.add("12343");
        matricula.add("12344");
        matricula.add("12345");
        matricula.add("12346");
        matricula.add("12347");
        matricula.add("12348");
        matricula.add("12349");

        //Nombres qe se almacenaran en la matriculas de cada alumno
        nombre.add("Reynaldo");
        nombre.add("Daniela");
        nombre.add("Luis");
        nombre.add("Facundo");
        nombre.add("Daniel");
        nombre.add("Carlos");
        nombre.add("Sarah");
        nombre.add("Fernanda");
        nombre.add("Sayuri");
        nombre.add("Christopher");

        //Generos de los alumnos
        genero.add("hombre");
        genero.add("mujer");
        genero.add("hombre");
        genero.add("hombre");
        genero.add("hombre");
        genero.add("hombre");
        genero.add("mujer");
        genero.add("mujer");
        genero.add("mujer");
        genero.add("hombre");

        //niveles academicos de los alumnos
        nivel.add("profesional");
        nivel.add("profesional");
        nivel.add("profesional");
        nivel.add("profesional");
        nivel.add("profesional");
        nivel.add("preparatoria");
        nivel.add("preparatoria");
        nivel.add("preparatoria");
        nivel.add("preparatoria");
        nivel.add("preparatoria");

    }
    public static void registro()
    {
        boolean out = false;
        boolean valid = false;
        String id;
        System.out.println("Ingrese su matricula");
        input = scan.nextLine();

        //con este for la aplicacion evaluara todas la matriculas en la database
        //hasta que coincida con alguna existente y muestre el mensaje de bienvenida

        for (int i=0; i<espacio; i++)
        {
            id = matricula.get(i);
            if (input.equals("cerrar"))
            {
                System.out.println("Ingrese su contraseña");
                for (int p=0; p<3; p++)
                {
                    input = scan.nextLine();
                    if (input.equals("password"))
                    {
                        loop = true;
                        out = true;
                        valid = true;
                        admin();

                    }
                    else
                    {
                        System.out.println("Contraseña incorrecta");
                    }
                }
            }
            else if (input.equals(id))
            {
                if (genero.get(i).equals("hombre"))
                {
                    System.out.print("Bienvenido\n");
                }
                else
                {
                    System.out.print("Bienvenida\n");
                }
                System.out.println(nombre.get(i));
                valid = true;
                if (genero.get(i).equals("hombre"))
                {
                    countmen++;
                }
                else
                {
                    countwomen++;
                }
                if (nivel.get(i).equals("profesional"))
                {
                    countuni++;
                }
                else
                {
                    countprepa++;
                }
                countvisitas++;
            }
        }
        //si el sistema termina de evaluar y la matricula ingresada no coincide con ninguna
        //entrara a un ciclo infinito que le pedira una matricula valida
        if (valid==false)
        {
            while (valid==false)
            {
                System.out.println("ingresa una matricula valida");
                input = scan.nextLine();
                for (int j=0; j<espacio; j++)
                {
                    id = matricula.get(j);
                    if (input.equals(id))
                    {
                        if (genero.get(j).equals("hombre"))
                        {
                            System.out.print("Bienvenido\n");
                        }
                        else
                        {
                            System.out.print("Bienvenida\n");
                        }
                        System.out.println(nombre.get(j));
                        valid=true;
                        //Esta seccion cuenta si son de prepa, uni, mujer u hombre
                        if (genero.get(j).equals("hombre"))
                        {
                            countmen++;
                        }
                        else
                        {
                            countwomen++;
                        }
                        if (nivel.get(j).equals("profesional"))
                        {
                            countuni++;
                        }
                        else
                        {
                            countprepa++;
                        }
                        countvisitas++;
                    }
                }
            }
        }
        //esta seccion pregunta al alumno a donde se dirige
        if (out==false)
        {
            System.out.println("\n¿A donde se dirige?\n1 Biblioteca\n2 Cubiculo\n3 Clase");
            while (true)
            {
                input = scan.nextLine();
                if (!input.equals("1") && !input.equals("2") && !input.equals("3"))
                {
                    System.out.println("Ingresa una opcion valida");
                }
                else
                    {
                    if (input.equals("1"))
                    {
                        countbiblio++;
                    }
                    else if (input.equals("2"))
                    {
                        countcubiculo++;
                    }
                    else if (input.equals("3"))
                    {
                        countclase++;
                    }
                    break;
                }
            }
        }
    }
    public static void admin()
    {
        //esta seccion despliega el menu para el administrador
        //que permitira añadir alumno, iniciar el sistema o crear el informe de las visitas
        System.out.println("¿Que desea hacer?\n1 Añadir alumno\n2 Eliminar alumno\n3 Iniciar sistema de registro\n4 Crear informe de visitas\n5 Salir");
        while (true)
        {
            input = scan.nextLine();
            if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"))
            {
                System.out.println("Ingresa una opcion valida");
            }
            else
            {
                if (input.equals("1"))
                {
                    if (espacio==0)
                    {
                        System.out.println("No hay alumnos registrados");
                        admin();
                    }
                    System.out.println("             Bienvenido al sistema de alta de alumnos");
                    System.out.println("   por favor introduzca los datos del alumno que desea registrar\n");
                    alta();
                }
                else if (input.equals("2"))
                {
                    baja();
                    admin();
                }
                else if (input.equals("3"))
                {
                    loop=false;
                    System.out.println("    Escriba 'cerrar' y luego ingrese su contraseña\n    cuando desee cerrar el sistema de registro\n");
                    while (true)
                    {
                        registro();
                        if (loop==true)
                        {
                            break;
                        }
                    }
                    admin();
                }
                else if (input.equals("4"))
                {
                    informe();
                    System.out.println();
                    admin();
                }
                else if (input.equals("5"))
                {
                    System.out.println("Gracias por usar el registro");
                    System.exit(0);
                }
            }
        }
    }
    public static void informe()
    {
        //esta seccion imprime el informe final de las visitas hechas a la biblioteca
        System.out.println("    Informe de visitas a biblioteca");
        System.out.println("Numero de visitas: "+countvisitas);
        System.out.println("Visitas de hombres: "+countmen);
        System.out.println("Visitas de mujeres: "+countwomen);
        System.out.println("Visitas de universitarios: "+countuni);
        System.out.println("Visitas de preparatorianos: "+countprepa);
        System.out.println("Visitas a biblioteca: "+countbiblio);
        System.out.println("Visitas a cubiculo: "+countcubiculo);
        System.out.println("Visitas a clase: "+countclase);
    }
    public static void alta()
    {
        //esta seccion permite añadir nuevos alumnos al sistema
        String id;
        String id2;
        boolean valido=false;
        boolean valido2=false;
        //Aqui el sistema determinara si la matricula ingresada esta dentro de los parametros de solo 5 numeros entre el 0 y el 9
        System.out.println("Ingrese matricula del alumno");
        while(true)
        {

            while(true)
            {
                input = scan.nextLine();
                for (int i=0; i<espacio; i++)
                {
                    id2 = matricula.get(i);
                    if (input.equals(id2))
                    {
                        System.out.println("La matricula ingresada ya existe, ingrese una nueva");
                        valido2=false;
                        break;
                    }
                    else
                    {
                        valido2=true;
                    }
                }
                if (valido2==true)
                {
                    break;
                }
            }
            char char1=' ';
            for (int c=0; c<5; c++)
            {
                if (input.length()!=5)
                {
                    System.out.println("Solo se aceptan matriculas de 5 digitos con numeros del 0 al 9");
                    System.out.println("Ingrese de nuevo la matricula");
                    valido=false;
                    break;
                }
                char1 = input.charAt(c);
                if (char1==('0') || char1==('1') || char1==('2') || char1==('3') || char1==('4') || char1==('5') || char1==('6') || char1==('7') || char1==('8') || char1==('9'))
                {
                    valido=true;
                }
                else
                {
                    System.out.println("Solo se aceptan matriculas de 5 digitos con numeros del 0 al 9");
                    System.out.println("Ingrese de nuevo la matricula");
                    valido=false;
                    break;
                }
            }
            if (valido==true)
            {
                break;
            }
        }
        id=input;
        matricula.add(id);

        String name;
        System.out.println("Ingrese nombre del alumno");
        input = scan.nextLine();
        name=input;
        nombre.add(name);

        System.out.println("Ingrese genero del alumno\n1=Hombre 2=Mujer");
        while (true)
        {
            String man = "hombre";
            String woman = "mujer";
            input = scan.nextLine();

            if (!input.equals("1") && !input.equals("2"))
            {
                System.out.println("Ingresa una opcion valida");
            }
            else
            {
                if (input.equals("1"))
                {
                    genero.add(man);
                    break;
                }
                else
                {
                    genero.add(woman);
                    break;
                }
            }
        }

        System.out.println("Ingrese nivel academico del alumno\n1=Profesional 2=Preparatoria");
        while (true)
        {
            String uni = "profesional";
            String prepa = "preparatoria";
            input = scan.nextLine();

            if (!input.equals("1") && !input.equals("2"))
            {
                System.out.println("Ingresa una opcion valida");
            }
            else
            {
                if (input.equals("1"))
                {
                    nivel.add(uni);
                    break;
                }
                else
                {
                    nivel.add(prepa);
                    break;
                }
            }
        }
        espacio++;
        admin();

    }
    public static void baja()
    {
        //esta seccion permite eliminar alumnos de la base de datos
        boolean exist=false;
        String id;
        if (espacio==0)
        {
            System.out.println("No hay alumnos registrados");
            admin();
        }
        System.out.println("Ingrese la matricula del alumno que desea eliminar");
        while(true)
        {
            //en este apartado el sistema verificara que la matricula que se desee eliminar exista
            input = scan.nextLine();
            for (int i = 0; i < espacio; i++)
            {
                id = matricula.get(i);
                if (input.equals(id))
                {
                    matricula.remove(i);
                    nombre.remove(i);
                    genero.remove(i);
                    nivel.remove(i);
                    espacio--;
                    exist=true;
                    System.out.println("Alumno eliminado\n");
                    admin();
                    break;
                }

            }
            if (exist==false)
            {
                System.out.println("Ingrese una matricula existente");
            }
        }

    }
}

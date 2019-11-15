import java.util.ArrayList;
import java.util.Scanner;

public class proyecto
{
    private static int countvisitas;
    private static int countmen;
    private static int countwomen;
    private static int countprepa;
    private static int countuni;
    private static int countbiblio;
    private static int countcubiculo;
    private static int countclase;

    private static boolean loop=false;
    private static boolean salir=false;

    private static Scanner scan = new Scanner(System.in);
    private static String input;

    private static int espacio=11;
    private static ArrayList<String> matricula = new ArrayList<String>();
    private static ArrayList<String> nombre = new ArrayList<String>();
    private static ArrayList<String> genero = new ArrayList<String>();
    private static ArrayList<String> nivel = new ArrayList<String>();

    public static void main(String args[])
    {
        database();

        admin();

        System.out.println("Gracias por usar el registro");

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
        for (int i=0; i<espacio-1; i++)
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
                        break;
                    }
                    else
                    {
                        System.out.println("Contraseña incorrecta");
                    }
                }
            }
            else if (input.equals(id))
            {
                System.out.println("Bieenvenido(a)\n" + nombre.get(i));
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
                for (int j = 0; j < espacio-1; j++)
                {
                    id = matricula.get(j);
                    if (input.equals(id))
                    {
                        System.out.println("Bieenvenido(a)\n" + nombre.get(j));
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
        System.out.println("¿Que desea hacer?\n1 añadir alumno\n2 iniciar sistema de registro\n3 Crear informe de visitas\n4 Salir");
        while (true)
        {
            input = scan.nextLine();
            if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4"))
            {
                System.out.println("Ingresa una opcion valida");
            }
            else
            {
                if (input.equals("1"))
                {
                    alta();
                }
                else if (input.equals("2"))
                {
                    loop=false;
                    System.out.println("    Escriba 'cerrar' y luego ingrese su ccontraseña\n    cuando desee cerrar el sistema de registro\n");
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
                else if (input.equals("3"))
                {
                    informe();
                    System.out.println();
                    admin();
                }
                else if (input.equals("4"))
                {
                    break;
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
        System.out.println("Ingrese matricula del alumno");
        input = scan.nextLine();
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
                    genero.add(uni);
                    break;
                }
                else
                {
                    genero.add(prepa);
                    break;
                }
            }
        }
        espacio++;
        admin();

    }
}

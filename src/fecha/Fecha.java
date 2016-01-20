/*
 * Paquete fecha que vamos a utilizar para crear una clase fecha y verificar  
 * que las fechas introducidas esten correctas y realizar diferentes operaciones 
 * con las fechas
 */
package fecha;

/**
 * Clase fecha en la que con los atributos dia, mes, anno iremos realizando todas
 * las operaciones que durante el curso se realizen con fechas
 * @author Raúl David Martínez González
 */
public class Fecha 
{//INICIO CLASE FECHA
    
    /**
     * atributos dia, mes y año y vector static de los dias que tiene cada mes
     */
    private int dia;
    private int mes;
    private int anno;
    static private int [] diasMes={31,28,31,30,31,30,31,31,30,31,30,31};


    /**
     * constructor clase
     */
    public Fecha() 
    {//inicio constructor
    }//fin constructor

    
    /**
     * metodo get para acceder al atributo dia
     * @return atributo dia
     */
    public int getDia() 
    {//inicio getDia()
        return dia;
    }//fin getDia()

    /**
     * metodo set para cambiar el atributo dia
     * @param dia valor que se quiere dar al atributo
     */
    public void setDia(int dia) 
    {//inicio setDia()
        this.dia = dia;
    }//fin setDia()

    /**
     * metodo get para acceder al atributo mes
     * @return atributo mes
     */
    public int getMes() 
    {//inicio getMes()
        return mes;
    }//fin getMes()

    /**
     * metodo set para cambiar el atributo mes
     * @param mes valor que se quiere dar al atributo
     */
    public void setMes(int mes) 
    {//inicio setMes()
        this.mes = mes;
    }//fin setMes()

    /**
     * metodo para acceder al atributo anno
     * @return atributo anno
     */
    public int getAnno() 
    {//inicio getAnno()
        return anno;
    }//fin getAnno()
   
    /**
     * metodo set para cambiar el atributo anno
     * @param anno valor que se quiere dar al atributo
     */
    public void setAnno(int anno) 
    {//inicio setAnno
        this.anno = anno;
    }//fin setAnno
    
    
    /**
     * metodo que calcula si el año con el que estamos trabajando es bisiesto
     * y devuelve el numero de dias que tiene el mes de febrero
     * @return numero de dias del mes febrero
     */
    public int bisiesto()
    {//inicio bisiesto()
        int dias=28;
        if((anno%4==0 && anno%100!=0)|| (anno%400==0))
        {//si el año es bisiesto
            dias=29;
        }//fin si el año es bisiesto
        return dias;
    }//fin bisiesto()
    
    /**
     * metodo que calcula si el año que se le pasa es bisiesto
     * y devuelve el numero de dias que tiene el mes de febrero
     * @return numero de dias del mes febrero
     * @param a pasamos el año
     */
    public int bisiesto(int a)
    {
        int dias=28;
        if((a%4==0 && a%100!=0)|| (a%400==0))
        {//si el año es bisiesto
            dias=29;
        }//fin si el año es bisiesto
        return dias;
    }
    
    /**
     * metodo que calcula si el año con el que estamos trabajando es bisiesto
     * y devuelve el numero de dias que tiene el año
     * @return numero de dias del año (365 ó 366)
     */
    public int annoBisiesto()
    {//inicio annoBisiesto()
        int dias=365;
        if((anno%4==0 && anno%100!=0)|| (anno%400==0))
        {//si el año es bisiesto
            dias=366;
        }//fin si el año no es bisiesto
        return dias;
    }//fin annoBisiesto()
    
     /**
     * metodo que calcula si el año con el que estamos trabajando es bisiesto
     * y devuelve el numero de dias que tiene el año
     * @return numero de dias del año (365 ó 366)
     */
    public int annoBisiesto(int a)
    {//inicio annoBisiesto()
        int dias=365;
        if((a%4==0 && a%100!=0)|| (a%400==0))
        {//si el año es bisiesto
            dias=366;
        }//fin si el año no es bisiesto
        return dias;
    }//fin annoBisiesto()
    
    /**
     * metodo que comprueba que la fecha que se ha introducido es la correcta
     * @param d dia
     * @param m mes
     * @param a año
     * @return devuelve un boolean que indica si es correcta o no la fecha
     */
    public boolean comprobarFecha(int d, int m, int a)
    {//inicio comprobarFecha
        boolean resultado=true;
        if (a<0)//si el año es menor que 0
            //la el resultado del metodo es erroneo
            resultado=false;
        else 
        {//si no el año es mayor que 0
            //preguntamos si el mes esta entre 1 y 12
            if (m<1 || m>12)
                //si no esta entre esos valores el resultado es erroneo
                resultado=false;
            else
            {//si no es <1 y >12
                //llamamos al metodo bisiesto y asignamos lo que dev. a febrero
                diasMes[1]=bisiesto(a);
                //si el dia introducido es <1 y > que los dias del mes erronea
                if(d<1 || d>diasMes[m-1])
                    resultado=false;
            }//fin si no es <1 y >12
        }//fin si no el año es mayor que 0
        
        return resultado;
    }//fin comprobarFecha
    
    /**
     * metodo que calcula los dias que han pasado del año hasta la fecha que 
     * introducimos
     * @return los dias del año que han pasado hasta la fecha
     */
    public int diaspasanAno()
    {//metodo diaspasanAno
        int diasHastaFecha=0;//vble para acumular los dias que han pasado
        int mes;//vble para ir recorriendo los meses
        diasMes[1]=bisiesto(anno);//compruebo si el año es bisiesto 
        for (mes=1;mes<this.mes;mes++)//bucle que recorre el vector diasMes
        {//inicio for
            //acumulo los dias del mes hasta que llege al introducido
            diasHastaFecha=diasHastaFecha+diasMes[mes-1];
        }//fin for
        diasHastaFecha=diasHastaFecha+dia;//acumulo los dias del mes no completo
        return diasHastaFecha;
    }//fin metodo diaspasanAnno   
    
          
    /**
     * Metodo que calcula los dias que quedan para acabar el año  
     * @return los dias que faltan para que se termine el año
     */    
    public int diasQuedan()
    {//metodo diasQuedan()
        int diasDesdeFecha=0; //vble en la que acumulamos los dias que van quedando   
        /*llamamos al metodo para saber los dias que han pasado hasta la fecha
        y los restamos de los dias que tiene el año
        */
        diasDesdeFecha=annoBisiesto()-diaspasanAno();
        return diasDesdeFecha;   
    }//metodo diasQuedan()
     
    /**
     * metodo que compara la fecha con la que se llama al metodo con la que se
     * envia como parametro y nos devuelve un entero que nos devuelve (0 si son
     * iguales, 1 si la fecha1 es menor que la fecha2 y 2 si es al contrario)
     * @param fecha devuelve el entero que indica cual de las 2 fechas es mayor
     * @return 
     */
    public int comparaFechas(Fecha fecha) 
    {//metodo comparaFechas()
        int resultado=0;
        
        //si el año de la fecha1 es menor que la fecha2 resultado=1 
        if (anno<fecha.getAnno())
            resultado=1;
        else 
        {//si año1 no menor
            //si el año de fecha1 es mayor que la fecha2 resultado=2
            if (anno>fecha.getAnno())
                resultado=2;
            else 
            {//si año1 y año2 iguales 
                //si mes de fecha1 menor que la fecha2 resultado=1
                if (mes<fecha.getMes()) 
                   resultado=1;
                else 
                {//si mes1 no menor que mes2
                   //si mes de fecha1 mayor que la fecha2 resultado=2 
                   if (mes>fecha.getMes())
                       resultado=2;
                   else 
                   {//si mes1 es igual que mes2
                       //si dia de fecha1 menor que la fecha2 resultado=1
                       if (dia<fecha.getDia())
                           resultado=1;
                       else 
                       {//si dia1 no menor que dia2
                           //si dia de fecha1 mayor que la fecha2 resultado=2
                           if (dia>fecha.getDia())
                               resultado=2;
                       }//fin si dia1 no menor que dia2
                   }//si mes1 es igual que mes2
               }//fin si mes1 no menor que mes2
            }//fin sin año1 y año2 iguales               
        }//fin si año1 no menor
        return resultado;
    }//fin metodo comparaFechas()
    
    /**
     * metodo que nos dice los dias que van desde una fecha mayor hasta otra
     * menor (es decir resta 2 fechas)
     * @param fecha2 pasamos fecha mayor (llamamos al metodo con la fecha pequeña)
     * @return numero de dias que van de una fecha a la otra
     */
    public int restarFecha(Fecha fecha2)
    {//inicio restarFecha()
        int dias=0;
        int m=mes;//vble para recorrer array diasMes
        int a=anno+1;//vble para recorrer años completos 
        
        if (anno==fecha2.getAnno())
        {//si el año es igual en las 2 fechas
            if (mes==fecha2.getMes())
            {//si el mes es igual en las 2 fechas
                //dia mayor menos dia menor
                dias=fecha2.getDia()-dia;
            }//si el mes es igual en las 2 fechas
            else 
            {//si el mes no es igual en las 2 fechas+
                /*acumulo los dias que quedan desde la fecha menor hasta el 
                final del mes no completo
                */
                dias=diasMes[mes-1]-dia;
                
                /*recorro desde el mes siguiente a la fecha pequeña hasta el 
                mes de la fecha mayor y acumulo los dias de cada mes completo
                */
                while (m<(fecha2.getMes()-1))
                {//principio while
                    dias=dias+diasMes[m];
                    m++;
                }//fin while
                
                dias=dias+fecha2.getDia();//acumulo los dias de la fecha mayor                 
            }//fin si el mes no es igual en las 2 fechas               
        }//fin si el año es igual en las 2 fechas
        
        else 
        {//si el año es diferente
            //acumulo los dias que faltan hasta fin de año de la fecha pequeña
            dias=this.diasQuedan(); 
            
            /*acumulo los dias de los años completos hasta llegar al año de la
            fecha mayor*/
            while(a<fecha2.getAnno())
            {//inicio while
                dias=dias+annoBisiesto(a);
                a++;
            }//fin while
            
            //acumulo los dias que han pasado de la fecha mayor
            dias=dias+fecha2.diaspasanAno();
             
        }//fin si el año es diferente
        return dias;//devuelvo los dias de diferencia
    }//fin restarFecha()
    
    public Fecha fechaVencimiento(int diasV)
    { 
        Fecha fecha2=new Fecha();
        return fecha2;
    }
    
}//fin clase FECHA


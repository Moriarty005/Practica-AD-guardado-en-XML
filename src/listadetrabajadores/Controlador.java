/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadetrabajadores;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Alexeltocayo
 */
public final class Controlador {
    
    ArrayList<Cocinero> lista_cocineros;
    ArrayList<Plato> lista_de_platos;
    ArrayList<Restaurante> lista_de_restaurantes;
    ArrayList<Cliente> lista_de_clientes;
    

    public Controlador() throws IOException, FileNotFoundException, ClassNotFoundException, SAXException {
        
        
        this.lista_cocineros = new ArrayList<>();
        
        /*Cocinero juan = new Cocinero(1, 1050.5, "Juan Jose", "langostinos", 45);
        Cocinero charlowitt = new Cocinero(2, 1050.5, "Carlos Galvez", "Comida china", 35);
        Cocinero sergio = new Cocinero(3, 1050.5, "Sergio Martinez", "Kebab", 0);
        Cocinero antonia = new Cocinero(4, 1050.5, "Antonia Guardia", "Comida Mexicana", 12);
        
        this.lista_cocineros.add(juan);
        this.lista_cocineros.add(charlowitt);
        this.lista_cocineros.add(sergio);
        this.lista_cocineros.add(antonia);*/
        
        
        this.lista_de_platos = new ArrayList<>();
        
        /*Plato chinchillas = new Plato(1, "chinchillas al ajillo con alioli", "Umami, amargo", 15, 3);
        Plato revuleto_de_setas = new Plato(2, "Revuelto de setas con huevos rotos", "Umami", 25, 1);
        Plato sandwich = new Plato(3, "Sandwich Montecristo", "Umami", 15, 5);
        Plato kebab = new Plato(4, "Kebab oriental", "Umami", 15, 1);
        
        this.lista_de_platos.add(chinchillas);
        this.lista_de_platos.add(revuleto_de_setas);
        this.lista_de_platos.add(sandwich);
        this.lista_de_platos.add(kebab);*/
        
        this.lista_de_restaurantes = new ArrayList();
        
        /*Restaurante casaMari = new Restaurante(1, "Casa Mari", "Granda", 55, 10);
        Restaurante Bugi = new Restaurante(2, "Bugi", "Bilbao", 250, 50);
        Restaurante Arriaga = new Restaurante(3, "Arriaga", "Madrid", 147, 10);
        Restaurante Torcuato = new Restaurante(4, "Torcuato", "Granda", 15, 5);
        
        this.lista_de_restaurantes.add(casaMari);
        this.lista_de_restaurantes.add(Bugi);
        this.lista_de_restaurantes.add(Arriaga);
        this.lista_de_restaurantes.add(Torcuato);*/
        
        this.lista_de_clientes = new ArrayList<>();
        
        /*Cliente raul = new Cliente(1, "Renault", "Sí", "Sí", 15);
        Cliente alex = new Cliente(2, "Alejandro", "Sí", "No", 17);
        Cliente pablo = new Cliente(3, "Personal Castro", "Sí", "No", 8);
        Cliente nieto = new Cliente(4, "Nietoff", "No", "No", 5);
        
        this.lista_de_clientes.add(raul);
        this.lista_de_clientes.add(alex);
        this.lista_de_clientes.add(pablo);
        this.lista_de_clientes.add(nieto);*/
        
        this.leerXML(lista_cocineros, lista_de_platos, lista_de_restaurantes, lista_de_clientes);
        
        //this.sacarDeFicherosTodosLosDatos();
    }
    
    public Cocinero getCocineroAtPosition(int index){
        
        return this.lista_cocineros.get(index);
    }
    
    public void addCocineroToList(Cocinero eustaquio){
        
        this.lista_cocineros.add(eustaquio);
    }
    
    public int getCocineroListSize(){
        
        return this.lista_cocineros.size();
    }
    
    public void removeCocineroAt(int index){
        
        this.lista_cocineros.remove(index);
    }
    
    public void removeCocinero(Cocinero benito){
        
        this.lista_cocineros.remove(benito);
    }
    
    public Plato getPlatoAtPosition(int index){
        
        return this.lista_de_platos.get(index);
    }
    
    public void addPlatoToList(Plato queso){
        
        this.lista_de_platos.add(queso);
    }
    
    public int getPlatoListSize(){
        
        return this.lista_de_platos.size();
    }
    
    public void removePlatoAt(int index){
        
        this.lista_de_platos.remove(index);
    }
    
    public void removePlato(Plato jamon){
        
        this.lista_de_platos.remove(jamon);
    }
    
    public int buscarPlatiIdPorNombre(String nombre){
        
        for(int index = 0; index < this.lista_de_platos.size(); index++){
            
            if(this.lista_de_platos.get(index).getNombre_plato().equals(nombre)){
                return this.lista_de_platos.get(index).getId_plato();
            }
        }
        
        return -1;
    }
    
    public Restaurante getRestauranteAtPosition(int index){
        
        return this.lista_de_restaurantes.get(index);
    }
    
    public void addRestauranteToList(Restaurante bugi){
        
        this.lista_de_restaurantes.add(bugi);
    }
    
    public int getRestauranteListSize(){
        
        return this.lista_de_restaurantes.size();
    }
    
    public void removeRestauranteAt(int index){
        
        this.lista_de_restaurantes.remove(index);
    }
    
    public void removeRestaurante(Restaurante arriaga){
        
        this.lista_de_restaurantes.remove(arriaga);
    }
    
    public Cliente getClienteAtPosition(int index){
        
        return this.lista_de_clientes.get(index);
    }
    
    public void addClienteToList(Cliente charlowitt){
        
        this.lista_de_clientes.add(charlowitt);
    }
    
    public int getClienteListSize(){
        
        return this.lista_de_clientes.size();
    }
    
    public void removeClienteAt(int index){
        
        this.lista_de_clientes.remove(index);
    }
    
    public void removeCliente(Cliente matt){
        
        this.lista_de_clientes.remove(matt);
    }
    
    /*public void guardarEnFicheroCocineros() throws FileNotFoundException, IOException{
        
        File fichero = new File("Cocineros.dat");
        
        if(fichero.exists()){
            
            fichero.delete();
        }
        
        FileOutputStream flujo_de_salida = new FileOutputStream(fichero,true); 
        ObjectOutputStream sacar_datos = new ObjectOutputStream(flujo_de_salida); 
        
        for(int index = 0; index < this.lista_cocineros.size(); index++){

            sacar_datos.writeObject(this.lista_cocineros.get(index)); 
       }
       
        sacar_datos.close();
    }
    
    public void guardarEnFicheroPlatos() throws FileNotFoundException, IOException{
        
        File fichero = new File("Platos.dat");
        
        if(fichero.exists()){
            
            fichero.delete();
        }
        
        FileOutputStream flujo_de_salida = new FileOutputStream(fichero,true); 
        ObjectOutputStream sacar_datos = new ObjectOutputStream(flujo_de_salida); 
        
        for(int index = 0; index < this.lista_de_platos.size(); index++){

            sacar_datos.writeObject(this.lista_de_platos.get(index)); 
       }
        
        sacar_datos.close();
    }
    
    public void guardarEnFicheroRestaurantes() throws FileNotFoundException, IOException{
        
        File fichero = new File("Restaurantes.dat");
        
        if(fichero.exists()){
            
            fichero.delete();
        }
        
        FileOutputStream flujo_de_salida = new FileOutputStream(fichero,true); 
        ObjectOutputStream sacar_datos = new ObjectOutputStream(flujo_de_salida); 
        
        for(int index = 0; index < this.lista_de_restaurantes.size(); index++){

            sacar_datos.writeObject(this.lista_de_restaurantes.get(index)); 
       }
        
        sacar_datos.close();
    }
    
    public void guardarEnFicheroClientes() throws FileNotFoundException, IOException{
        
        File fichero = new File("Clientes.dat");
        
        if(fichero.exists()){
            
            fichero.delete();
        }
        
        FileOutputStream flujo_de_salida = new FileOutputStream(fichero,true); 
        ObjectOutputStream sacar_datos = new ObjectOutputStream(flujo_de_salida); 
        
        for(int index = 0; index < this.lista_de_clientes.size(); index++){

            sacar_datos.writeObject(this.lista_de_clientes.get(index)); 
       }
        
        sacar_datos.close();
    }
    
    public void guardarEnFircheroTodosLosDatos() throws IOException{
        
        this.guardarEnFicheroCocineros();
        this.guardarEnFicheroPlatos();
        this.guardarEnFicheroRestaurantes();
        this.guardarEnFicheroClientes();
    }
    
    public void sacarDeFicherosDatosCocineros() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File fichero = new File("Cocineros.dat");
        
        if(fichero.exists()){
            Cocinero prueba = new Cocinero();

            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

            try{
                for(int index2 = 0; index2 < fichero.length(); index2++){

                    prueba = (Cocinero) dataIS.readObject();

                    this.lista_cocineros.add(prueba);
                }
            }catch(EOFException e){
                System.out.println("FIN DE LECTURA");
            }catch(StreamCorruptedException x){

            }
        }else{
            System.out.println("No existe todavía el fichero");
        }
    }
    
    
    public void sacarDeFicherosDatosPlatos() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File fichero = new File("Platos.dat");
        
        if(fichero.exists()){
            Plato prueba = new Plato();

            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

            try{
                for(int index2 = 0; index2 < fichero.length(); index2++){

                    prueba = (Plato) dataIS.readObject();

                    this.lista_de_platos.add(prueba);
                }
            }catch(EOFException e){
                System.out.println("FIN DE LECTURA");
            }catch(StreamCorruptedException x){

            }
        }else{
            System.out.println("No existe todavía el fichero de platos");
        }
    }
    
    
    public void sacarDeFicherosDatosRestaurantes() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File fichero = new File("Restaurantes.dat");
        
        if(fichero.exists()){
            Restaurante prueba = new Restaurante();

            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

            try{
                for(int index2 = 0; index2 < fichero.length(); index2++){

                    prueba = (Restaurante) dataIS.readObject();

                    this.lista_de_restaurantes.add(prueba);
                }
            }catch(EOFException e){
                System.out.println("FIN DE LECTURA");
            }catch(StreamCorruptedException x){

            }
        }else{
            System.out.println("No existe todavía el fichero de restaurantes");
        }
    }
    
    
    public void sacarDeFicherosDatosClientes() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        File fichero = new File("Clientes.dat");
        
        if(fichero.exists()){
            Cliente prueba = new Cliente();

            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

            try{
                for(int index2 = 0; index2 < fichero.length(); index2++){

                    prueba = (Cliente) dataIS.readObject();

                    this.lista_de_clientes.add(prueba);
                }
            }catch(EOFException e){
                System.out.println("FIN DE LECTURA");
            }catch(StreamCorruptedException x){

            }
        }else{
            System.out.println("No existe todavía el fichero de clientes");
        }
    }
    
    public void sacarDeFicherosTodosLosDatos() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        this.sacarDeFicherosDatosCocineros();
        this.sacarDeFicherosDatosPlatos();
        this.sacarDeFicherosDatosRestaurantes();
        this.sacarDeFicherosDatosClientes();
    }*/
    
    void crearElemento(String dato, String valor, Element raiz, Document fichero){
        
        Element elem = fichero.createElement(dato); 
        Text text = fichero.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }
    
    
    public void convertirAXMLCocineros() throws FileNotFoundException, ParserConfigurationException, IOException{
        
        File persona = new File("Cocineros.xml");  
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        int posicion = 0;
        
         try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "cocineros", null);
            document.setXmlVersion("1.0"); 
            
             for(int index = 0; index < this.lista_cocineros.size(); index++){
                 
                 Element raiz = document.createElement("cocinero");
                 
                 document.getDocumentElement().appendChild(raiz);
                 
                 crearElemento("id_cocinero", this.lista_cocineros.get(index).getId_cocinero().toString(), raiz, document);
                 crearElemento("nombre_cocinero", this.lista_cocineros.get(index).getId_cocinero().toString(), raiz, document);
                 crearElemento("salario", this.lista_cocineros.get(index).getId_cocinero().toString(), raiz, document);
                 crearElemento("especialidad", this.lista_cocineros.get(index).getId_cocinero().toString(), raiz, document);
                 crearElemento("n_premios", this.lista_cocineros.get(index).getId_cocinero().toString(), raiz, document);
                 crearElemento("plato_que_cocina", this.lista_cocineros.get(index).getId_cocinero().toString(), raiz, document);
                 
             }
             
             Source direccion = new DOMSource(document);
             
             Result result = new StreamResult(new java.io.File("Cocineros.xml"));
             
             Transformer optimus_prime = TransformerFactory.newInstance().newTransformer();
             
             optimus_prime.transform(direccion, result);
             
             
         }catch(Exception e){
             
             System.err.println("Error: "+e);
        }
    }
    
    public void convertirAXMLPlatos() throws FileNotFoundException, ParserConfigurationException, IOException{
        
        File persona = new File("Platos.xml");  
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        
         try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "platos", null);
            document.setXmlVersion("1.0"); 
            
             for(int index = 0; index < this.lista_de_platos.size(); index++){
                 
                 Element raiz = document.createElement("plato");
                 
                 document.getDocumentElement().appendChild(raiz);
                 crearElemento("id_plato", String.valueOf(this.lista_de_platos.get(index).getId_plato()), raiz, document);
                 crearElemento("nombre_plato", this.lista_de_platos.get(index).getNombre_plato(), raiz, document);
                 crearElemento("sabor_principal", this.lista_de_platos.get(index).getSabor_principal(), raiz, document);
                 crearElemento("tiempo_preparación", String.valueOf(this.lista_de_platos.get(index).getTiempo_de_prep()), raiz, document);
                 crearElemento("n_ingrediente", String.valueOf(this.lista_de_platos.get(index).getNum_ingredientes()), raiz, document);
                 crearElemento("restaurante_donde_se_sirve", String.valueOf(this.lista_de_platos.get(index).getId_restaurante_donde_se_sirve_este_plato()), raiz, document);
                 
             }
             
             Source direccion = new DOMSource(document);
             
             Result result = new StreamResult(new java.io.File("Platos.xml"));
             
             Transformer optimus_prime = TransformerFactory.newInstance().newTransformer();
             
             optimus_prime.transform(direccion, result);
             
             
         }catch(Exception e){
             
             System.err.println("Error: "+e);
        }
         System.out.println("HEYHEYHEYHEYHEYHEHYHEYHEYHEYHEHYEHYEHYEYHEHYEYHEY");
         for(int index = 0; index < this.getPlatoListSize(); index++){
             System.out.println("Plato: " + this.lista_de_platos.get(index).toString());
         }
    }
    
    public void convertirAXMLRestaurantes() throws FileNotFoundException, ParserConfigurationException, IOException{
        
        File persona = new File("Restaurantes.xml");  
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        int posicion = 0;
        
         try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "restaurantes", null);
            document.setXmlVersion("1.0"); 
            
             for(int index = 0; index < this.lista_de_restaurantes.size(); index++){
                 
                 Element raiz = document.createElement("restaurante");
                 
                 document.getDocumentElement().appendChild(raiz);
                 crearElemento("id_restaurante", String.valueOf(this.lista_de_restaurantes.get(index).getId_restaurante()), raiz, document);
                 crearElemento("nombre_restaurante", this.lista_de_restaurantes.get(index).getNombre_restaurante(), raiz, document);
                 crearElemento("direccion", this.lista_de_restaurantes.get(index).getDireccion_restaurante(), raiz, document);
                 crearElemento("aforo_maximo", String.valueOf(this.lista_de_restaurantes.get(index).getAforo_maximo_restaurante()), raiz, document);
                 crearElemento("n_empleados", String.valueOf(this.lista_de_restaurantes.get(index).getAforo_maximo_restaurante()), raiz, document);
                 crearElemento("cliente_al_que_sirve_restaurante", String.valueOf(this.lista_de_restaurantes.get(index).getId_cliente_que_al_que_restaurante_vende()), raiz, document);
                 System.out.println("Valor del id de restaurante en la celda " + index + " y valor de su cliente: " + this.lista_de_restaurantes.get(index).getId_cliente_que_al_que_restaurante_vende());
             }
             
             Source direccion = new DOMSource(document);
             
             Result result = new StreamResult(new java.io.File("Restaurantes.xml"));
             
             Transformer optimus_prime = TransformerFactory.newInstance().newTransformer();
             
             optimus_prime.transform(direccion, result);
             
             
         }catch(Exception e){
             
             System.err.println("Error: "+e);
        }
    }
    
    public void convertirAXMLClientes() throws FileNotFoundException, ParserConfigurationException, IOException{
        
        File persona = new File("Clientes.xml");  
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        int posicion = 0;
        
         try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "clientes", null);
            document.setXmlVersion("1.0"); 
            
             for(int index = 0; index < this.lista_de_clientes.size(); index++){
                 
                 Element raiz = document.createElement("cliente");
                 document.getDocumentElement().appendChild(raiz);
                 
                 crearElemento("id_cliente", String.valueOf(this.lista_de_clientes.get(index).getId_cliente()), raiz, document);
                 crearElemento("nombre_cliente", this.lista_de_clientes.get(index).getNombre_cliente(), raiz, document);
                 crearElemento("reserva", this.lista_de_clientes.get(index).getReserva().toString(), raiz, document);
                 crearElemento("alergico", this.lista_de_clientes.get(index).getAlergico(), raiz, document);
                 crearElemento("coste_de_la_comida", String.valueOf(this.lista_de_clientes.get(index).getCoste_de_la_comida()), raiz, document);
                 crearElemento("restaurante_donde_comio", String.valueOf(this.lista_de_clientes.get(index).getId_restaurante_donde_comio()), raiz, document);
                 
             }
             
             Source direccion = new DOMSource(document);
             
             Result result = new StreamResult(new java.io.File("Clientes.xml"));
             
             Transformer optimus_prime = TransformerFactory.newInstance().newTransformer();
             
             optimus_prime.transform(direccion, result);
             
             
         }catch(Exception e){
             
             System.err.println("Error: "+e);
        }
    }
    
    public void guardarTodosLosDatosEnXML() throws ParserConfigurationException, IOException{
        
        this.convertirAXMLCocineros();
        this.convertirAXMLPlatos();
        this.convertirAXMLRestaurantes();
        this.convertirAXMLClientes();
    }
    
    
    class gestorCocineros extends DefaultHandler{
        
        
        public String elemento;
        public String elemento_raiz;
        
        public ArrayList<Cocinero> cooks;
        //public ArrayList<Plato> dishes;
        //public ArrayList<Restaurante> restaurant;
       // public ArrayList<Cliente> client;
        
        public Cocinero juan;
        //public Plato patatas_bravas;
       // public Restaurante torcuato;
        //public Cliente antonio;
        
        public gestorCocineros(ArrayList<Cocinero> cocinerillos/*, ArrayList<Plato> platillos, ArrayList<Restaurante> restaurantillos, ArrayList<Cliente> clientillos */) {
            super();
            
            elemento = "";
            elemento_raiz = "";
            
            cooks = cocinerillos;
            //dishes = platillos;
            //restaurant = restaurantillos;
            //client = clientillos;
            
            juan = new Cocinero();
            //patatas_bravas = new Plato();
            //torcuato = new Restaurante();
            //antonio = new Cliente();
        }
        
        public void startDocument() {
            System.out.println("Comienzo del Documento XML");
        }
        
        public void endDocument() {
            System.out.println("Final del Documento XML");
        }
        
        public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
            System.out.printf("\t Principio Elemento: %s %n",nombre);
            elemento = nombre;
            
            if(nombre == "cocineros"){
                this.elemento_raiz = nombre;
            }/*else if(nombre == "platos"){
                this.elemento_raiz = nombre;
            }else if(nombre == "restaurantes"){
                this.elemento_raiz = nombre;
            }else if(nombre == "clientes"){
                this.elemento_raiz = nombre;
            } */
        }
        
        public void endElement(String uri, String nombre, String nombreC) {
            System.out.printf("\tFin Elemento: %s %n", nombre);
            
            if(nombre == "cocinero"){
                cooks.add(juan);
                juan = new Cocinero();
            }/*else if(nombre == "platos"){
                dishes.add(patatas_bravas);
                patatas_bravas = new Plato();
            }else if(nombre == "restaurantes"){
                restaurant.add(torcuato);
                torcuato = new Restaurante();
            }else if(nombre == "clientes"){
                client.add(antonio);
                antonio = new Cliente();
            }*/
        }
        
        @Override
        public void characters(char[] ch, int inicio, int longitud){
               String car=new String(ch, inicio, longitud);
           //quitar saltos de línea	
               car = car.replaceAll("[\t\n]","");	   
               System.out.printf ("\t Caracteres: %s %n", car);	
               
            if(this.elemento_raiz == "cocineros"){

                if(this.elemento == "id_cocinero"){
                    juan.setId_cocinero(Integer.parseInt(car));
                }else if(this.elemento == "nombre_cocinero"){
                    juan.setNombre(car);
                }else if(this.elemento == "salario"){
                     juan.setSalario(Double.parseDouble(car));
                }else if(this.elemento == "especialidad"){
                    juan.setEspecialidad(car);
                }else if(this.elemento == "n_premios"){
                    juan.setNumero_de_premios(Integer.parseInt(car));
                }else if(this.elemento == "plato_que_cocina"){
                    juan.setId_del_plato_que_cocina_este_cocinero(Integer.parseInt(car));
                }
            /*}else if(this.elemento_raiz == "platos"){
                
                if(this.elemento == "id_plato"){
                    patatas_bravas.setId_plato(Integer.parseInt(car));
                }else if(this.elemento == "nombre_plato"){
                    patatas_bravas.setNombre_plato(car);
                }else if(this.elemento == "sabor_principal"){
                    patatas_bravas.setSabor_principal(car);
                }else if(this.elemento == "tiempo_preparación"){
                    patatas_bravas.setTiempo_de_prep(Integer.parseInt(car));
                }else if(this.elemento == "n_ingrediente"){
                    patatas_bravas.setNum_ingredientes(Integer.parseInt(car));
                }else if(this.elemento == "restaurante_donde_se_sirve"){
                    patatas_bravas.setId_restaurante_donde_se_sirve_este_plato(Integer.parseInt(car));
                }
            }else if(this.elemento_raiz == "restaurantes"){
                
                if(this.elemento == "id_restaurante"){
                    torcuato.setId_restaurante(Integer.parseInt(car));
                }else if(this.elemento == "nombre_restaurante"){
                    torcuato.setNombre_restaurante(car);
                }else if(this.elemento == "direccion"){
                    torcuato.setDireccion_restaurante(car);
                }else if(this.elemento == "aforo_maximo"){
                    torcuato.setAforo_maximo_restaurante(Integer.parseInt(car));
                }else if(this.elemento == "n_empleados"){
                    torcuato.setNumero_empleados_restaurante(Integer.parseInt(car));
                }else if(this.elemento == "cliente_al_que_srive_restaurante"){
                    torcuato.setId_cliente_que_al_que_restaurante_vende(Integer.parseInt(car));
                }
            }else if(this.elemento_raiz == "clientes"){
                
                if(this.elemento == "id_cliente"){
                    antonio.setId_cliente(Integer.parseInt(car));
                }else if(this.elemento == "nombre_cliente"){
                    antonio.setNombre_cliente(car);
                }else if(this.elemento == "reserva"){
                    antonio.setReserva(car);
                }else if(this.elemento == "alergico"){
                    antonio.setAlergico(car);
                }else if(this.elemento == "coste_de_la_comida"){
                    antonio.setCoste_de_la_comida(Integer.parseInt(car));
                }else if(this.elemento == "restaurante_donde_comio"){
                    antonio.setId_restaurante_donde_comio(Integer.parseInt(car));
                } */          
            }
        }	
    }
    
    class gestorPLatos extends DefaultHandler{
    
        public String elemento;
        
        public ArrayList<Plato> dishes;
        
        public Plato patatas_bravas;
        
        public gestorPLatos(ArrayList<Plato> platillos) {
            super();
            
            elemento = "";
            
            dishes = platillos;
            
            patatas_bravas = new Plato();
        }
        
        public void startDocument() {
            System.out.println("Comienzo del Documento XML");
        }
        
        public void endDocument() {
            System.out.println("Final del Documento XML");
        }
        
        public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
            System.out.printf("\t Principio Elemento: %s %n",nombre);
            elemento = nombre;
            
        }
        
        public void endElement(String uri, String nombre, String nombreC) {
            System.out.printf("\tFin Elemento: %s %n", nombre);
            
            if(nombre == "plato"){
                System.out.println("Plato que vamos a insertar: " + patatas_bravas.toString());
                dishes.add(patatas_bravas);
                patatas_bravas = new Plato();
            }
        }
        
        @Override
        public void characters(char[] ch, int inicio, int longitud){
               String car=new String(ch, inicio, longitud);
           //quitar saltos de línea	
               car = car.replaceAll("[\t\n]","");	   
               System.out.printf ("\t Caracteres: %s %n", car);	
               
                
                if(this.elemento == "id_plato"){
                    patatas_bravas.setId_plato(Integer.parseInt(car));
                }else if(this.elemento == "nombre_plato"){
                    patatas_bravas.setNombre_plato(car);
                }else if(this.elemento == "sabor_principal"){
                    patatas_bravas.setSabor_principal(car);
                }else if(this.elemento == "tiempo_preparación"){
                    patatas_bravas.setTiempo_de_prep(Integer.parseInt(car));
                }else if(this.elemento == "n_ingrediente"){
                    patatas_bravas.setNum_ingredientes(Integer.parseInt(car));
                }else if(this.elemento == "restaurante_donde_se_sirve"){
                    patatas_bravas.setId_restaurante_donde_se_sirve_este_plato(Integer.parseInt(car));
                }
        }
    }
    
    class gestorRestaurantes extends DefaultHandler{
    
        public String elemento;
        
        public ArrayList<Restaurante> restaurantes;
        
        public Restaurante bugi;
        
        public gestorRestaurantes(ArrayList<Restaurante> res) {
            super();
            
            elemento = "";
            
            restaurantes = res;
            
            bugi = new Restaurante();
        }
        
        public void startDocument() {
            System.out.println("Comienzo del Documento XML");
        }
        
        public void endDocument() {
            System.out.println("Final del Documento XML");
        }
        
        public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
            System.out.printf("\t Principio Elemento: %s %n",nombre);
            elemento = nombre;
            
        }
        
        public void endElement(String uri, String nombre, String nombreC) {
            System.out.printf("\tFin Elemento: %s %n", nombre);
            
            if(nombre == "restaurante"){
                restaurantes.add(bugi);
                bugi = new Restaurante();
            }
        }
        
        @Override
        public void characters(char[] ch, int inicio, int longitud){
               String car=new String(ch, inicio, longitud);
           //quitar saltos de línea	
               car = car.replaceAll("[\t\n]","");	   
               System.out.printf ("\t Caracteres: %s %n", car);	
               
            if(this.elemento == "id_restaurante"){
                bugi.setId_restaurante(Integer.parseInt(car));
            }else if(this.elemento == "nombre_restaurante"){
                bugi.setNombre_restaurante(car);
            }else if(this.elemento == "direccion"){
                bugi.setDireccion_restaurante(car);
            }else if(this.elemento == "aforo_maximo"){
                bugi.setAforo_maximo_restaurante(Integer.parseInt(car));
            }else if(this.elemento == "n_empleados"){
                bugi.setNumero_empleados_restaurante(Integer.parseInt(car));
            }else if(this.elemento == "cliente_al_que_sirve_restaurante"){
                bugi.setId_cliente_que_al_que_restaurante_vende(Integer.parseInt(car));
System.out.println("Id del cliente que vamos a leer: " + bugi.getId_cliente_que_al_que_restaurante_vende());
            }
        }
    }
    
    class gestorClientes extends DefaultHandler{
    
        public String elemento;
        
        public ArrayList<Cliente> res;
        
        public Cliente juan;
        
        public gestorClientes(ArrayList<Cliente> cliente) {
            super();
            
            elemento = "";
            
            res = cliente;
            
            juan = new Cliente();
        }
        
        public void startDocument() {
            System.out.println("Comienzo del Documento XML");
        }
        
        public void endDocument() {
            System.out.println("Final del Documento XML");
        }
        
        public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
            System.out.printf("\t Principio Elemento: %s %n",nombre);
            elemento = nombre;
            
        }
        
        public void endElement(String uri, String nombre, String nombreC) {
            System.out.printf("\tFin Elemento: %s %n", nombre);
            
            if(nombre == "cliente"){
                res.add(juan);
                juan = new Cliente();
            }
        }
        
        @Override
        public void characters(char[] ch, int inicio, int longitud){
               String car=new String(ch, inicio, longitud);
           //quitar saltos de línea	
               car = car.replaceAll("[\t\n]","");	   
               System.out.printf ("\t Caracteres: %s %n", car);	
               
            if(this.elemento == "id_cliente"){
                    juan.setId_cliente(Integer.parseInt(car));
                }else if(this.elemento == "nombre_cliente"){
                    juan.setNombre_cliente(car);
                }else if(this.elemento == "reserva"){
                    juan.setReserva(car);
                }else if(this.elemento == "alergico"){
                    juan.setAlergico(car);
                }else if(this.elemento == "coste_de_la_comida"){
                   juan.setCoste_de_la_comida(Integer.parseInt(car));
                }else if(this.elemento == "restaurante_donde_comio"){
                    juan.setId_restaurante_donde_comio(Integer.parseInt(car));
                }
        }
    }
    
    public void leerXML(ArrayList<Cocinero> cocinerillos, ArrayList<Plato> platillos, ArrayList<Restaurante> restaurantillos, ArrayList<Cliente> clientillos) throws org.xml.sax.SAXException, IOException, SAXException{
                
        XMLReader  procesadorXMLCocineros = XMLReaderFactory.createXMLReader();
        XMLReader  procesadorXMLPlatos = XMLReaderFactory.createXMLReader();
        XMLReader  procesadorXMLRestaurantes = XMLReaderFactory.createXMLReader();
        XMLReader  procesadorXMLClientes = XMLReaderFactory.createXMLReader();
        
        
        gestorPLatos gp = new gestorPLatos(platillos);
        
        gestorCocineros gc = new gestorCocineros(cocinerillos);
        
        gestorRestaurantes gr = new gestorRestaurantes(restaurantillos);
        
        gestorClientes gclients = new gestorClientes(clientillos);
        
	procesadorXMLCocineros.setContentHandler(gc);
        procesadorXMLPlatos.setContentHandler(gp);
        procesadorXMLRestaurantes.setContentHandler(gr);
        procesadorXMLClientes.setContentHandler(gclients);
        
 	InputSource cocinerosXML = new InputSource("Cocineros.xml");
        InputSource platosXML = new InputSource("Platos.xml");
        InputSource restaurantesXML = new InputSource("Restaurantes.xml");
        InputSource clientesXML = new InputSource("Clientes.xml");
        
        File cocineros = new File("Cocineros.xml");
        File platos = new File("Platos.xml");
        File restaurantes = new File("Restaurantes.xml");
        File clientes = new File("Clientes.xml"); 
       
        if(cocineros.exists()){
            procesadorXMLCocineros.parse(cocinerosXML); 
        }else{
            System.out.println("No existe el fichero");
        }
        
        if(platos.exists()){
            procesadorXMLPlatos.parse(platosXML);
        }else{
            System.out.println("No existe el fichero");
        }
        
        if(restaurantes.exists()){
           procesadorXMLRestaurantes.parse(restaurantesXML); 
        }else{
            System.out.println("No existe el fichero");
        }
        
        if(clientes.exists()){
            procesadorXMLClientes.parse(clientesXML);  
        }else{
            System.out.println("No existe el fichero");
        }
    }
        
        
}

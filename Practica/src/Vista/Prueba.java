package Vista;

import Controlador.ControladorJDBC;
import Modelo.Entrenadores;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Prueba {
 static ControladorJDBC ec = new ControladorJDBC();
 public static void main(String[] args) {
  Scanner tecladoNum = new Scanner(System.in);
  Scanner teclado = new Scanner(System.in);
  boolean bucle = true;
  while (bucle == true) {
   System.out.println("MENU:");
   System.out.println("1.Seleccionar todos los entrenadores:");
   System.out.println("2.Seleccionar entrenadores por Id:");
   System.out.println("3.Insertar entrenadores:");
   System.out.println("4.Actualizar entrenador por el id:");
   System.out.println("5.Borrar entrenador:");
   System.out.println("6.Seleccionar entrenador por nombre:");
   System.out.println("0.Salir:");
   System.out.println("Elija una opción: ");
   int opcion = teclado.nextInt();
   switch (opcion) {
    case 1: {
     SelectAll();
     break;
    }
    case 2: {
     SeleccionarEntrenadorId();
     break;
    }
    case 3: {
     InsertarEntrenador();
     break;
    }
    case 4: {
     ActualizaEntrenador();
     break;
    }
    case 5: {
        BorrarEntrenador();
     break;
    }
    case 6: {
        SeleccionarEntrenadorNombre();
     break;
    }
    case 0: {
     bucle = false;
     break;
    }
    default:
     throw new IllegalArgumentException("Unexpected value: " + opcion);
   }
  }
 }

 private static void SeleccionarEntrenadorNombre() {
    Scanner teclado = new Scanner(System.in);
    System.out.println("Introduce el nombre del entrenador que quieres seleccionar: ");
    String nombre = teclado.nextLine();
    ArrayList<Entrenadores> lista = ec.SelectByName(nombre);
    for (int i = 0; i < lista.size(); i++) {
     System.out.println(lista.get(i));
    }
 }

 private static void BorrarEntrenador() {
    Scanner tecladoNum = new Scanner(System.in);
    System.out.println("Introduce el id del entrenador que quieres borrar: ");
    int id = tecladoNum.nextInt();
    ec.DeleteEntrenador(id);
 }

 private static void SelectAll() {
  ArrayList<Entrenadores> lista = ec.SelectAll();
  for (int i = 0; i < lista.size(); i++) {
   System.out.println(lista.get(i));
  }
 }

 private static void SeleccionarEntrenadorId( ) {
  Scanner tecladoNum = new Scanner(System.in);
  System.out.println("Introduce el id del entrenador que quieres seleccionar: ");
  int id = tecladoNum.nextInt();
  Entrenadores e = ec.SelectByEntrenadorId(id);
  System.out.println(e);
  ArrayList<Entrenadores> lista = ec.SelectById(id);
  for (int i = 0; i < lista.size(); i++) {
   System.out.println(lista.get(i));
 }
 }

 private static void ActualizaEntrenador() {
  Scanner tecladoNum = new Scanner(System.in);
  Scanner teclado = new Scanner(System.in);
  System.out.println("Introduce el id del entrenador que quieres actualizar: ");
  int id = tecladoNum.nextInt();
  System.out.println("Introduce el nombre del entrenador que quieres actualizar: ");
  String nombre = teclado.nextLine();
  System.out.println("Introduce la edad del entrenador que quieres actualizar: ");
  int edad = tecladoNum.nextInt();
  System.out.println("Introduce el id del equipo del entrenador que quieres actualizar: ");
  int id_equipos = tecladoNum.nextInt();
  ec.UpdateEntrenador(id, nombre, edad, id_equipos);
 }

 private static void InsertarEntrenador() {
  Scanner tecladoNum = new Scanner(System.in);
  Scanner teclado = new Scanner(System.in);
  System.out.println("Introduce el id del entrenador que quieres insertar: ");
  int id = tecladoNum.nextInt();
  System.out.println("Introduce el nombre del entrenador que quieres insertar: ");
  String nombre = teclado.nextLine();
  System.out.println("Introduce la edad del entrenador que quieres insertar: ");
  int edad = tecladoNum.nextInt();
  System.out.println("Introduce el id del equipo del entrenador que quieres insertar: ");
  int id_equipo = tecladoNum.nextInt();
  ec.InsertEntrenador(id, nombre, edad, id_equipo);
 }
}
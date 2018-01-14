package com.cice.negocio;

import java.util.ArrayList;
import java.util.Scanner;

import com.cice.modelo.Persona;

/**
 * 
 * @author Javier Bajo Chacon  javier.bajochacon@gmail.com
 *
 */

public class Gestora {
	
	private ArrayList <Persona> listaPersonas= new ArrayList <>();	
	
	public void showMenu() {
		Scanner sc = new Scanner (System.in);
		int opcion = 0;
		
		do {
			System.out.println("------------------------------------");
			System.out.println("Bienvenido a tu gestor de contactos");
			System.out.println("Esto es lo que puedo hacer por ti:");
			System.out.println("1. Crear Persona");
			System.out.println("2. Eliminar Datos Persona");
			System.out.println("3. Mostrar Personas");			
			System.out.println("0. Salir");
			System.out.println("------------------------------------");
			opcion = sc.nextInt();
			
			controles (opcion);			
		}while (opcion!=0);
		sc.close();
	}
	
	private void controles (int opcion) {
		switch (opcion){
			case 0:
				break;
			case 1:
				//Crear Persona
				crearPersona();
				break;
			case 2:
				//Eliminar Datos Persona
				eliminarDatosPersona();
				break;
			case 3:
				//Mostrar Persona
				mostrarPersona();
				break;			
			default:
				System.out.println("la opcion seleccionada no es valida");
				
				
		}
	}
	
	private void crearPersona () {
		Persona persona;
		Scanner sc = new Scanner (System.in);
		String nombre;
		String dni;
		
		System.out.println("Introduce un nombre");
		nombre=sc.nextLine();			
		System.out.println("Introduce un DNI");
		dni=sc.next();		
		while(comprobarPersona(dni)) {
			System.out.println("Los datos de esta persona ya existen");
			System.out.println("Introduce un DNI");
			dni=sc.next();		
		}
		persona = new Persona (nombre, dni);
		listaPersonas.add(persona);
		
			
	}
	
	private boolean comprobarPersona(String dni) {
		
		boolean bandera = false;
		
		if(listaPersonas.size()>0)
		for (Persona per : listaPersonas) {
			if(per.getDni().equals(dni))
				bandera = true;
			
		}
		return bandera;
		
	}
	
	private void eliminarDatosPersona() {
		int opcion = 0;
		int seleccion = 0;
		Scanner sc = new Scanner (System.in);
		
		if(listaPersonas.size()>0) {
			for (Persona persona : listaPersonas) {
				System.out.println("------------------------------------------------");
				System.out.println("Seleccione una persona cuyos datos vaya a eliminar");
				System.out.println(opcion+1 + ") " + persona.toString());
				opcion++;
			}
		System.out.println("------------------------------------------------");
		seleccion = sc.nextInt();
		seleccion--;
		if(seleccion < listaPersonas.size()) {
			listaPersonas.remove(seleccion);
		}
		else {
			System.out.println("Opcion erronea");
		}
		
		}
		else {
			System.out.println("La Agenda esta vacia todavia debe crear un contacto antes");
		}
		
	}
	
	private void mostrarPersona() {
		int opcion = 0;
		

		if(listaPersonas.size()>0) {
		for (Persona persona : listaPersonas) {
			System.out.println("------------------------------------------------");
			System.out.println(opcion+1 + ") " + persona.toString());
			opcion++;
		}
		System.out.println("------------------------------------------------");
		}
		else {
			System.out.println("La Agenda esta vacia todavia debe crear un contacto antes");
		}
	}
}
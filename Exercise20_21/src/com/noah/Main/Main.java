package com.noah.Main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
				 new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
				 new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
				 new Circle(6.5), new Rectangle(4, 5)};
		
		selectionSort(list, new GeometricObjectComparator());
		
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].getArea() + " ");
		}
	}
	public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {

		for(int i = 0; i < list.length - 1; i++) {
			int minValInd = i;
			for(int j = i + 1; j < list.length; j++) {
				if(comparator.compare(list[j], list[minValInd]) < 0) {
					minValInd = j;
				
				}

			}
			E temp = list[minValInd];
			list[minValInd] = list[i];
			list[i] = temp;
		}
		
	}
}

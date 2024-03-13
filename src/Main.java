import java.util.ArrayList;
import java.util.Arrays;

interface SortMachine {
	public void sort(ArrayList<Integer> insertNums);
}

class BubbleSortMachine implements SortMachine {

	@Override
	public void sort(ArrayList<Integer> nums) {
		bubbleSort(nums);
	}

	void bubbleSort(ArrayList<Integer> lst){
		for(int cycle = 0 ;cycle < lst.size(); cycle ++) {
			for(int i = 0 ; i < lst.size() - 1 - cycle; i ++) {
				if(lst.get(i) > lst.get(i + 1)){
					//swap
					int tmp = lst.get(i);
					lst.set(i, lst.get(i + 1));
					lst.set(i + 1, tmp);
				}
			}
		}
	}
}

class SelectionSortMachine implements SortMachine {

	@Override
	public void sort(ArrayList<Integer> nums) {
		selectionSort(nums);
	}

	void selectionSort(ArrayList<Integer> lst) {
		for(int i = 0 ; i < lst.size(); i++) {
			for(int j = i + 1 ; j < lst.size(); j ++) {
				if(lst.get(i) > lst.get(j)){
					int tmp = lst.get(i);
					lst.set(i, lst.get(j));
					lst.set(j, tmp);
				}
			}
		}
	}

}

class SortPrinter {
	SortMachine sortMachine;
	ArrayList<Integer> insertNums;

	void insert(ArrayList<Integer> nums) {
		insertNums = nums;
	}

	void selection(SortMachine sortMachine) {
		this.sortMachine = sortMachine;
	}

	void run() {
		sortMachine.sort(insertNums);
	}

	void show() {
		System.out.println(insertNums);
	}
}

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(3,3,3,2,1,1,2,3,2,1,2,3,1,2,3,2,1,5,5,2,1,7));

		SortPrinter sortPrinter = new SortPrinter();
		sortPrinter.insert(lst);
		sortPrinter.show();

		sortPrinter.selection(new BubbleSortMachine());
		sortPrinter.run();
		sortPrinter.show();

		sortPrinter.selection(new SelectionSortMachine());
		sortPrinter.run();
		sortPrinter.show();
	}
}
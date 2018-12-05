package chap11.JavaSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Storage storage1 = new Storage()
										.setDate(Calendar.getInstance().getTime())
										.setId(UUID.randomUUID().toString())
										.setName("C");
		
		
		Storage storage2 = new Storage()
										.setDate(Calendar.getInstance().getTime())
										.setId(UUID.randomUUID().toString())
										.setName("D");
		
		Storage storage3 = new Storage()
										.setDate(Calendar.getInstance().getTime())
										.setId(UUID.randomUUID().toString())
										.setName("F");
		
		Storage storage4 = new Storage()
				.setDate(Calendar.getInstance().getTime())
				.setId(UUID.randomUUID().toString())
				.setName("F");
		ArrayList<Storage> list = new ArrayList<>();
		list.add(storage1);
		list.add(storage3);
		list.add(storage2);
		list.add(storage4);
		Storage[] arrStorage = list.toArray(new Storage[list.size()]);
		
		System.out.println("정렬 전 : "+Arrays.toString(list.toArray()));
		
		list.sort(Comparator.comparing(Storage::getName));
		System.out.println("정렬 후 : "+Arrays.toString(list.toArray()));
		
		System.out.println();
		
		System.out.println("배열 정렬 전 : "+Arrays.toString(arrStorage));
		Arrays.sort(arrStorage);
		System.out.println("배열 정렬 후 : "+Arrays.toString(arrStorage));
		// 배열로 변환후 솔트 ...
		
		System.out.println();
		
		/*
			람다식을 이용한 정렬
		*/
		Comparator<Storage> nameComparatorDESC = ( (o1, o2) -> {
				// TODO Auto-generated method stub
				return o2.getName().compareTo(o1.getName());
		});
		list.sort(nameComparatorDESC);
		System.out.println("이름 DESC 정렬 : "+ Arrays.toString(list.toArray()));
		
		Comparator<Storage> nameComparatorASC = ( (o1, o2) -> {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		});
		list.sort(nameComparatorASC);
		System.out.println("이름 ASC 정렬 : "+ Arrays.toString(list.toArray()));
		
		Comparator<Storage> dateComparatorDesc = ( (o1, o2) -> {
			// TODO Auto-generated method stub
			return o2.getDate().compareTo(o1.getDate());
		});
		list.sort(dateComparatorDesc);
		System.out.println("날짜 DESC 정렬 : "+ Arrays.toString(list.toArray()));
		
		Comparator<Storage> dateComparatorAsc = ( (o1, o2) -> {
			// TODO Auto-generated method stub
			return o1.getDate().compareTo(o2.getDate());
		});
		list.sort(dateComparatorAsc);
		System.out.println("날짜 ASC 정렬 : "+ Arrays.toString(list.toArray()));
		
		list.sort(Storage.nameStaticComparatorDESC);
		System.out.println("날짜 ASC 정렬 : "+ Arrays.toString(list.toArray()));
		
	}

}

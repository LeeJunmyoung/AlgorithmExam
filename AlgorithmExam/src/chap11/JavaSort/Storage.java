package chap11.JavaSort;

import java.util.Comparator;
import java.util.Date;

public class Storage implements Comparable<Storage> {

	private String id;
	
	private String name;
	
	private Date date;

	public String getId() {
		return id;
	}

	public Storage setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Storage setName(String name) {
		this.name = name;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public Storage setDate(Date date) {
		this.date = date;
		return this;
	}

	@Override
	public int compareTo(Storage o) {
		// TODO Auto-generated method stub
		return this.date.compareTo(o.getDate());
	}

	@Override
	public String toString() {
		return "Storage [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
	
	public static Comparator<Storage> nameStaticComparatorDESC = ( (o1, o2) -> {
		// TODO Auto-generated method stub
		return o2.getName().compareTo(o1.getName());
	});
	
	
}

package ca.mcgill.ece.audio.misc;

public class Reference<E>{
	private E data;
	public void set(E e) {
		data = e;
	}
	public E get() {
		return data;
	}
}

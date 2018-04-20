package llPositionalList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import interfaces.Position;
import interfaces.PositionalList;

public class PositionalListElementsBackwardIterator<E> extends LinkedPositionalList<E> implements Iterator<E> {
		LinkedPositionalList<E> list =  new LinkedPositionalList<E>();
		Position<E> current;
		Position<E> recent;
		
		public PositionalListElementsBackwardIterator(PositionalList<E> linkedPositionalList) {
			this.list = (LinkedPositionalList<E>) linkedPositionalList; 
			current = linkedPositionalList.last();
			recent = null; 
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext())
				throw new NoSuchElementException("No more elements.");
			recent = current;
			current = list.before(current);
			return recent.getElement();
		}

		public void remove() throws IllegalStateException {
			if (recent == null)
				throw new IllegalStateException("remove() not valid at this state of the iterator.");
			list.remove(recent);
			recent = null; 
		}
	}

package co.devrandom.model;

public class TimedEvent implements Triggerable, Comparable<TimedEvent> {
	private Model model;
	private long start;
	private long end;
	
	public TimedEvent(Model model, long timeUntil) {
		this.model = model;
		start = model.getElapsedTime();
		end = start + timeUntil;
	}
	
	public long getEnd() {
		return end;
	}
	
	@Override
	public int compareTo(TimedEvent other) {
		return (int) (this.getEnd() - other.getEnd());
	}

	@Override
	public void onTrigger() {

	}

	@Override
	public boolean isTriggered() {
		return model.getElapsedTime() >= end;
	}
}

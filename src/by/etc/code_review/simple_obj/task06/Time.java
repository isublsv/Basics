package by.etc.code_review.simple_obj.task06;

/**
 * 6. Составьте описание класса для представления времени. Предусмотрите возможности установки времени и изменения его
 * отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае недопустимых значений
 * полей поле устанавливается в значение 0. Создать методы изменения времени на заданное количество часов, минут и
 * секунд.
 */

public class Time {

	private int hours;
	private int minutes;
	private int seconds;

	public Time() {

		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
	}

	public Time(int hours, int minutes, int seconds) {

		setHours(hours);
		setMinutes(minutes);
		setSeconds(seconds);
	}

	public void setHours(int hours) {

		if (hours >= 24 || hours < 0) {
			this.hours = 0;
		} else {
			this.hours = hours;
		}

	}

	public int getHours() {
		return hours;
	}

	public void addHours(int hours) {

		this.hours += hours;

		if (this.hours >= 0) {
			this.hours = this.hours % 24;
		} else {
			this.hours = 24 - Math.abs(this.hours % 24);
		}
	}

	public void setMinutes(int minutes) {

		if (minutes >= 60 || minutes < 0) {
			this.minutes = 0;
		} else {
			this.minutes = minutes;
		}

	}

	public int getMinutes() {
		return minutes;
	}

	public void addMinutes(int minutes) {

		this.minutes += minutes;

		if (this.minutes >= 0) {
			if (this.minutes >= 60) {
				addHours(this.minutes / 60);
				this.minutes = this.minutes % 60;
			}
		} else {
			this.minutes = getHours() * 60 + this.minutes;
			setHours(this.minutes / 60);
			this.minutes = Math.abs(this.minutes % 60);
		}

	}

	public void setSeconds(int seconds) {

		if (seconds >= 60 || seconds < 0) {
			this.seconds = 0;
		} else {
			this.seconds = seconds;
		}

	}

	public int getSeconds() {
		return seconds;
	}

	public void addSeconds(int seconds) {

		this.seconds += seconds;

		if (this.seconds >= 0) {
			if (this.seconds >= 60) {
				addHours(this.seconds / 3600);
				addMinutes(this.seconds / 60);
				this.seconds = this.seconds % 60;
			}
		} else {
			this.seconds = getHours() * 3600 + getMinutes() * 60 + this.seconds;
			setHours(this.seconds / 3600);
			setMinutes((this.seconds - getHours() * 3600)/ 60);
			this.seconds = this.seconds % 60;
		}

	}

	@Override
	public String toString() {
		return "Current time is " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds.";
	}
}

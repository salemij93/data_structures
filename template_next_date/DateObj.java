package template_next_date;


/**
 * Implements a next date function for the sake of learning
 * unit test strategies.
 */
public class DateObj {
	
	private int year;
	private int month;
	private int day;
	private int[] monthLengths = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public DateObj(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
		validate();
	}


	public DateObj nextDate() {
		// TODO: return the next valid date after this one
		return null;
	}

	@Override
	public String toString() {
		return String.format("Date[year: %d, month: %d, day: %d]", year, month, day);
	}

	private void validate() {
		// TODO: throw an exception if the current values of year, month and day do not
		//       make a valid date
		if (this.year < 0) throw new IllegalArgumentException();
        if ((this.month < 1) || (this.month > 12)) throw new IllegalArgumentException();
        if ((this.day < 1) || (this.day > 31)) throw new IllegalArgumentException();
        switch (this.month) {
            case 1: return ;
            case 2:  if(isLeapYear(this.year) ? this.day <= 29 : this.day <= 28) return;
            case 3: return ;
            case 4: if( this.day < 31) return;
            case 5: return ;
            case 6: if( this.day < 31) return;
            case 7: return;
            case 8: return;
            case 9: if( this.day < 31) return;
            case 10: return ;
            case 11: if( this.day < 31) return;
            default: return ;
        }
	}
	private boolean isLeapYear(int year) {
	if (year % 4 != 0) {
        return false;
      } else if (year % 400 == 0) {
        return true;
      } else if (year % 100 == 0) {
        return false;
      } else {
        return true;
      }        

	}
}

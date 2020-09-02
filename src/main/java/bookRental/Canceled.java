package bookRental;

public class Canceled extends AbstractEvent {

    private Long pointId;
    private Long bookingId;
    private String pointStatus;

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public String getPoingstatus() {
        return pointStatus;
    }

    public void setPoingstatus(String pointStatus) {
        this.pointStatus = pointStatus;
    }
}
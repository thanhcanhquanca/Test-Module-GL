package codegym.c10.testbookings.eNum;

public enum TrangThai {
    TRONG("Trống"),
    HA_TANG("Hạ Tầng"),
    DAY_DU("Đầy Đủ");

    private final String value;
    TrangThai(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static TrangThai fromString(String text) {
        for (TrangThai trangThai : TrangThai.values()) {
            if (trangThai.value.equalsIgnoreCase(text)) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái: " + text);
    }
}

package codegym.c10.testbookings.eNum;

public enum LoaiMatBang {
    VAN_PHONG_CHIA_SE("Văn Phòng Chia Sẻ"),
    VAN_PHONG_CHON_GOI("Văn Phòng Chọn Gói");

    private final String value;
    LoaiMatBang(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static LoaiMatBang fromString(String value) {
        for (LoaiMatBang loaiMatBang : LoaiMatBang.values()) {
            if (loaiMatBang.value.equals(value)) {
                return loaiMatBang;
            }
        }
        throw new IllegalArgumentException();
    }
}

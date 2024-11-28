class Transaksi extends Barang {
    private int noFaktur;
    private int jumlahBeli;
    private double total;

    public Transaksi(int noFaktur, String kodeBarang, String namaBarang, double hargaBarang) {
        super(kodeBarang, namaBarang, hargaBarang);
        if (hargaBarang < 1) {
            throw new IllegalArgumentException("Harga barang tidak benar!");
        }
        this.noFaktur = noFaktur;
    }

    public void setJumlahBeli(int jumlahBeli) {
        if (jumlahBeli < 1) {
            throw new IllegalArgumentException("Jumlah beli tidak boleh 0!");
        }
        this.jumlahBeli = jumlahBeli;
        this.total = this.hargaBarang * this.jumlahBeli;
    }

    public void tampilkanTransaksi() {
        System.out.println("No Faktur: " + noFaktur);
        System.out.println("Kode Barang: " + kodeBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Harga Barang: " + hargaBarang);
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total: " + total);
    }
}

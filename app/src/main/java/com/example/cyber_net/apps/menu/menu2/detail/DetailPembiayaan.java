package com.example.cyber_net.apps.menu.menu2.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cyber_net.apps.R;
import com.example.cyber_net.apps.model.IsiTabungan;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.cyber_net.apps.helper.Constan.KEY_DATA;

public class DetailPembiayaan extends AppCompatActivity {

    @BindView(R.id.txt_notif)
    TextView txtNotif;
    @BindView(R.id.txt_nama)
    TextView txtNama;
    @BindView(R.id.txt_nominal)
    TextView txtNominal;
    @BindView(R.id.wrapper)
    LinearLayout wrapper;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.txt_manfaat)
    TextView txtManfaat;
    @BindView(R.id.txt_keuntungan)
    TextView txtKeuntungan;
    @BindView(R.id.txt_syarat)
    TextView txtSyarat;
    @BindView(R.id.btn_buka)
    Button btnBuka;
    IsiTabungan data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tabungan);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data = getIntent().getParcelableExtra(KEY_DATA);
        if (data != null) {
            switch (data.getProduk()) {
                case "k. muna":
                    getSupportActionBar().setTitle("K. MUNA (KREDIT MULTI GUNA)");
                    txtDesc.setText("Kredit Multiguna (KMG) adalah salah satu produk perbankan yang memberikan fasilitas pinjaman dimana peminjam (debitur) diharuskan untuk memberikan agunan atau jaminan. ");
                    txtManfaat.setText("Limit Pinjaman Tinggi, Bisa Sampai Miliaran: \n" +
                            "Seperti yang sudah disebutkan di atas, salah satu keunggulan Kredit Multiguna adalah memiliki limit pinjaman tinggi. Kenapa bisa begitu? Salah satu alasannya karena dia membutuhkan jaminan aset sebagai syaratnya. Dengan begitu, risiko bank untuk merugi akibat nasabah mengalami gagal bayar akan lebih kecil dibandingkan Kredit Tanpa Agunan. ");
                    txtSyarat.setText("Memiliki pendapatan bulanan yang sesuai dengan produk KMG yang dipilih (Cth: minimum penghasilan Rp 7.000.000.-)\n" +
                            "Usia pemohon kredit harus diatas 21 tahun\n" +
                            "Usia pemohon kredit dibawah 55-60 tahun pada saat masa pelunasan");
                    Glide.with(this)
                            .load("http://cgblogassets.s3-ap-northeast-1.amazonaws.com/wp-content/uploads/sites/2/2016/09/30042741/00.-Header-Kartu-Kredit-Virtual.jpg")
                            .into(img);
                    btnBuka.setText("AJUKAN PEMBIAYAAN");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}

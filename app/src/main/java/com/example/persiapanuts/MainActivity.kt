package com.example.persiapanuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var data: ArrayList<DataModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inisialisasi Array
        data = ArrayList()


        //Simpan data
        data?.add(DataModel(R.drawable.icon,"Turunan (Differential)",R.drawable.rumus_turunan,
            "definisi turunan fungsi ( diferensial ) adalah fungsi lain dari suatu fungsi sebelumnya," +
                    " contohnya fungsi f dijadikan f' yang mempunyai nilai tidak memakai aturan. Sementara, pengertian" +
                    " turunan aljabar adalah perluasan dari materi limit fungsi.\n" +
                    "\n" +
                    "Secara umum, turunan fungsi memiliki definisi yaitu pengukuruan di mana hasil dari" +
                    " fungsi akan berubah sesuai dengan variabel yang kita masukan, atau secara umum suatu besaran" +
                    " yang berubah seiring perubahan besaran lainnya. Proses dalam menemukan turunan disebut sebagai diferensiasi."))
        data?.add(DataModel(R.drawable.icon,"Integral",R.drawable.rumus_integral,
            "Kita tahu bahwa ketika suatu fungsi, katakanlah fungsi f(x), diturunkan atau didiferensialkan " +
                    "maka akan diperoleh suatu fungsi baru, katakanlah f′(x). Jika fungsi baru f′(x) ini diintegralkan," +
                    " maka kita akan memperoleh fungsi f(x) itu sendiri. Itulah kenapa kita menyebut integral tak tentu " +
                    "sebagai operasi balikan atau antiturunan. "))
        data?.add(DataModel(R.drawable.icon,"Baris Aritmatika",R.drawable.rumus_barisan,
            "Barisan merupakan urutan dari suatu anggota-anggota himpunan berdasarkan suatu aturan tertentu. " +
                    "Setiap anggota himpunan diurutkan pada urutan/suku pertama, kedua, dan seterusnya. " +
                    "Untuk menyatakan urutan/suku ke-n dari suatu barisan dinotasikan U_n . Barisan juga dapat didefinisikan sebagai" +
                    " fungsi dari bilangan asli atau fungsi yang domainnya himpunan bilangan asli."))
        data?.add(DataModel(R.drawable.icon,"Deret Aritmatika",R.drawable.rumus_deretan,
            "Deret aritmatika adalah penjumlahan suku-suku dari suatu barisan aritmatika. Penjumlahan dari suku-suku petama sampai suku ke-n" +
                    "Jika hendak membuat sebuah baris aritmatika dengan telah diketahui nilai suku pertama (a) dan suku terakhirnya (p), dapat disisipkan sejumlah bilangan diantara keduan bilangan tersebut. " +
                    "Sejumlah bilangan (q buah) tersebut menjadi suku-suku baris aritmatika dan memiliki selisih antar suku beredekatan (b)."))

        //Set data to Adapter
        recyclerview.adapter = DataAdapter(data, object : DataAdapter.OnClickListener{
            override fun detail(item: DataModel?) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("gambar", item?.gambar)
                intent.putExtra("judul", item?.judul)
                intent.putExtra("rumus", item?.rumus)
                intent.putExtra("keterangan", item?.keterangan)
                startActivity(intent)
            }

        })


    }
}
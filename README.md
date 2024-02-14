# Reflection 1

Setelah mengerjakan *exercise 1* saya merasa pengetahuan tentang *clean code* sangat menguntungkan kita terutama saat kode kita sudah semakin kompleks.

Beberapa penerapa *clean code* yang saya coba terapkan pada projek ini adalah:

1. **Meaningful names**
   
   Pada projek ini saya merasa penggunaan nama pada variabel ataupun method yang saya gunakan sudah cukup jelas sehingga
   tidak perlu menambahkan komen untuk memberi info tambahan.

2. **Function**

   Pada projek ini saya telah menerapkan penggunaan function dengan cukup efisien seperti membuat function yang tidak terlalu luas penggunaannya,
   menggunakan nama function yang deskriptif, dan setiap function hanya mempunyai satu tujuan tertentu.

3. **Comments**

   Pada projek ini saya tidak menambahkan komen pada kode yang saya buat karena saya rasa kode saya sudah cukup jelas

4. **Object and data structure**

   Pada projek ini saya menggunakan konsep OOP agar kode lebih mudah untuk dipahami dan untuk alasan keamanan


Yang masih bisa dikembangkan dari kode saya pada projek ini adalah pada bagian *error handling* yang masih kurang baik

# Reflection 2

1. Setelah membuat unit test saya rasa kita bisa menjadi lebih paham tentang kode yang kita buat termasuk kasus-kasus yang belum ter*cover* oleh kode kita. 
Saya rasa jika memungkinkan kita harus menulis unit test sebanyak yang kita bisa dengan asumsi setiap tes mengecek kombinasi *case* yang berbeda.
Selain itu saya juga belajar bahwa kode yang memiliki 100% *coverage* bukan berarti kode kita sudah bebas dari bug karena *code coverage* hanya menunjukan seberapa banyak kode kita
yang sudah tercover oleh test yang kita buat tetapi bisa saja test yang kita buat tidak meng*cover* kasus-kasus tertentu.

2. Setelah saya membuat functional test untuk membuat produk saya rasa saya akan tetap menggunakan cara yang saya gunakan sekarang untuk membuat functional test untuk menghitung jumlah produk pada list produk karena saya rasa kode yang saya sekarang sudah cukup efisien dan bisa bekerja dengan baik



# Tutorial 2
# Reflection

1. 
* Mengubah field static ID pada productRepository menajadi non static

   Sebelumnya saya menggunakan static variable untuk men-set ID pada setiap product, namun Sonarcloud mendteksi bagian kode tersebut sebagai *code smeels* dan akhirnya saya menggantinya menjadi non static variabel dan meng-*increment* variabel ID dengan `this.ID++` setiap memanggil method `create` pada `productRepository`

* Mengubah method `System.out.println()` pada method `printAllProduct`untuk melakukan *debugging*

   Saya pertama kali menggunakan method `println()` untuk mengecek `field` Product setelah memanggil method `create()`. Hal ini saya lakukan karena saya tidak terbiasa menggunakan `logger` untuk melakukan *debugging*, namun Sonarcloud ternyata mendeteksi hal tersebut sebagai *code smeels* dan akhirnya saya menggantinya dengan menggunakan `logger`

* Mengubah variabel "ID" menjadi "id"

   Hal ini saya lakukan karena mendapat peringatan *code smeels* dari Sonarcloud karena tidak sesuai dengan pattern `'^[a-z][a-zA-Z0-9]*$'`

2. Menurut saya implementasi *workflow* saya pada modul kali ini sudah memenuhi definisi CI/CD, hal ini terlihat dari proses github actions di mana setiap terdapat `push` ke repo github, kode tersebut akan dites terlebih dahulu melalui workflow yang ada, selain itu kode saya pada modul ini juga sudah mengaplikasikan workflow Sonarcloud dan PMD yang dapat memeriksa seberapa *clean* kode saya sehingga jika terdapat masalah bisa langsung diperbaiki dan mencegah kemungkinan adanya bagian kode yang tidak terintegrasi dengan baik. Untuk bagian *continuous deployment* sendiri sudah diterapkan dengan cara melakukan merge ke branch `main` jika seluruh kode sudah siap untuk di-*deploy* dan akan otomatis ter-deploy ke platform Koyeb [(link deploy)](adpro-yodha.koyeb.app/product/list).

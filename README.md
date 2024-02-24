# Modul 1
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
---


# Modul 2
# Reflection

1. 
* Mengubah field static ID pada productRepository menajadi non static

   Sebelumnya saya menggunakan static variable untuk men-set ID pada setiap product, namun Sonarcloud mendteksi bagian kode tersebut sebagai *code smeels* dan akhirnya saya menggantinya menjadi non static variabel dan meng-*increment* variabel ID dengan `this.ID++` setiap memanggil method `create` pada `productRepository`

* Mengubah method `System.out.println()` pada method `printAllProduct`untuk melakukan *debugging*

   Saya pertama kali menggunakan method `println()` untuk mengecek `field` Product setelah memanggil method `create()`. Hal ini saya lakukan karena saya tidak terbiasa menggunakan `logger` untuk melakukan *debugging*, namun Sonarcloud ternyata mendeteksi hal tersebut sebagai *code smeels* dan akhirnya saya menggantinya dengan menggunakan `logger`

* Mengubah variabel "ID" menjadi "id"

   Hal ini saya lakukan karena mendapat peringatan *code smeels* dari Sonarcloud karena tidak sesuai dengan pattern `'^[a-z][a-zA-Z0-9]*$'`

2. Menurut saya implementasi *workflow* saya pada modul kali ini sudah memenuhi definisi CI/CD, hal ini terlihat dari proses github actions di mana setiap terdapat `push` ke repo github, kode tersebut akan dites terlebih dahulu melalui workflow yang ada, selain itu kode saya pada modul ini juga sudah mengaplikasikan workflow Sonarcloud dan PMD yang dapat memeriksa seberapa *clean* kode saya sehingga jika terdapat masalah bisa langsung diperbaiki dan mencegah kemungkinan adanya bagian kode yang tidak terintegrasi dengan baik. Untuk bagian *continuous deployment* sendiri sudah diterapkan dengan cara melakukan merge ke branch `main` jika seluruh kode sudah siap untuk di-*deploy* dan akan otomatis ter-deploy ke platform Koyeb (adpro-yodha.koyeb.app/product/list).
---

# Modul 3
1. Prinsip - prinsip SOLID yang sudah saya aplikasikan pada projek ini di antaranya adalah:
   * <b>Single Responsibility Principle (SRP)</b>
   
        Pemisahan modul CarController dan ProductController, pemisahan ini dilakukan agar setiap modul hanya mengerjakan
        setiap modul hanya memiliki satu tugas masing - masing. Modul CarController berfungsi untuk mengatur routing
        dari aplikasi Car dan modul ProductController berfungsi untuk mengatur routing aplikasi Product
   * <b>Open-Closed Principle (OCP) </b>
        
        Pada projek ini, penerapan OCP dilakukan pada class `Car` dan `Product` di mana class ini memiliki method
        `update` sehingga memungkinkan class lain yang mengextend kedua class tersebut untuk melakukan perubahan melalui
        method `update` sehingga tidak mengubah kode yang sudah ada
   * <b>Liskov Substitution Principle (LSP) </b>
   
        Pada projek ini tidak ada aplikasi dari LSP karena skala projek yang masih kecil sehingga kompleksitas class
        yang ada masih simpel dan belum ada yang mengaplikasikan LSP
   * <b> Interface Segregation Principle (ISP)</b>
        
        Penerapan ISP pada projek ini adalah implementasi class `CarServiceImpl` dan `ProductServiceImpl` yang
        hanya mengimplementasikan `interface` yang dibutuhkan
   * <b> Dependency Inversions Principle (DIP)</b>
        
        Penerapan DIP pada projek ini adalah `type` dari variabel pada `CarController` dan `ProductController`
        yang menggunakan `type` `CarService` dan `ProductService` daripada menggunakan `CarServiceImpl` dan `ProductServiceImpl`


2.  Beberapa Keuntungan menggunakan SOLID principle pada projek ini adalah:
    * Kemudahan dalam memaintain kode
      * Program yang dibuat pada projek ini terdiri dari beberapa modul dan setiap modul
      memiliki fungsinya masing-masing. Dengan pemisahan seperti ini, proses debugging kode
      akan menjadi lebih mudah dan kode juga memiliki readability yang lebih baik.
    * Kemudahan dalam melakukan testing
      * Method-method yang ada pada projek ini semuanya bersifat modular sehingga akan mempermudah
      dalam melakukan unit testing karena setiap unit test hanya mengetes satu method yang memiliki fungsi spesifik
      sehingga kita dapat mengetahui dengan mudah test case yang belum tercover oleh method kita jika terdapat test 
      yang fail
    * Kemudahan untuk melakukan ekstensi fitur
      * Dengan menggunakan open closed principle kita dapat menambahkan suatu fitur baru tanpa
      harus mengganti kode yang sudah ada, contoh dalam project ini adalah misal kita ingin menambahkan
      atribu baru pada objek `Car` kita bisa membuat class yang mengextend `Car` dan membuat atribut baru
      pada class tersebut

3. Kekurangan yang didapat jika tidak mengimplementasikan SOLID principle adalah sebagai berikut:
    * Sulit untuk memaintain kode
      * Salah satu contoh dari kesulitan memantain code jika tidak menerapkan SOLID principle adalah jika
        kode kita tidak menerapkan prinsip SRP karena kode kita akan terkonsentrasi pada satu class saja
        dengan fungsionalitas yang bermacam-macam. Hal ini akan sulit dimaintain di kemudian hari karena kita
        akan kesulitan untuk mengetahui tujuan dan fungsionalitas kode tersebut karena isinya yang terlalu banyak dan luas
    * Kesulitan untuk melakukan testing
      * Jika kita tidak menggunakan SOLID principle dan pada kode kita terdapat method yang isinya terlalu besar
        dan tidak memiliki fungsionalitas yang tunggal, kita akan kesulitan saat ingin melakukan unit test terhadap method tersebut
        karena akan ada kemungkinan variabel-variabel tertentu tidak terpikirkan oleh kita saat membuat tes dikarenakan method
        yang ingin ditest sudah terlalu besar
    * Riskan untuk menambahkan fitur baru
      * Jika kita tidak menerapkan prinsip OCP, ada kemungkinan kita akan merubah kode yang sudah ada jika
        kita ingin menambahkan suatu fitur tertentu. Hal ini tentunya berbahaya karena jika kode yang sudah ada kita rubah
        bisa jadi perubahan tersebut memiliki dampak terhadap kode lain yang saling dependent dan dapat menyebabkan masalah
        yang lebih kompleks
-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Jan 2021 pada 12.47
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stm`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_dettran`
--

CREATE TABLE `tbl_dettran` (
  `Periode` varchar(50) DEFAULT NULL,
  `Kode_siswa` varchar(10) DEFAULT NULL,
  `Kode_kelas` varchar(10) DEFAULT NULL,
  `kode_bayar` varchar(10) DEFAULT NULL,
  `Hutang` double DEFAULT NULL,
  `Lunas` double DEFAULT NULL,
  `group_kelas` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_dettran`
--

INSERT INTO `tbl_dettran` (`Periode`, `Kode_siswa`, `Kode_kelas`, `kode_bayar`, `Hutang`, `Lunas`, `group_kelas`) VALUES
('TAPEL 2021/2022', '1', 'KLS-1', '1', 0, 100000, 'Kelas 1'),
('TAPEL 2021/2022', '1', 'KLS-1', '2', 0, 150000, 'Kelas 1'),
('TAPEL 2021/2022', '1', 'KLS-1', '3', 0, 150000, 'Kelas 1'),
('TAPEL 2021/2022', '1', 'KLS-1', '4', 0, 150000, 'Kelas 1'),
('TAPEL 2021/2022', '1', 'KLS-1', '5', 0, 150000, 'Kelas 1'),
('TAPEL 2021/2022', '1', 'KLS-1', '6', 0, 150000, 'Kelas 1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_dettransaksi`
--

CREATE TABLE `tbl_dettransaksi` (
  `no_faktur` varchar(25) DEFAULT NULL,
  `kode_biaya` varchar(10) DEFAULT NULL,
  `jumlah` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_dettransaksi`
--

INSERT INTO `tbl_dettransaksi` (`no_faktur`, `kode_biaya`, `jumlah`) VALUES
('Kwi-001', '1', 50000),
('Kwi-001', '3', 150000),
('Kwi-001', '6', 100000),
('Kwi-001', '5', 150000),
('Auto Fill', '1', 50000),
('Auto Fill', '2', 150000),
('Auto Fill', '4', 150000),
('Auto Fill', '6', 50000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_kelas`
--

CREATE TABLE `tbl_kelas` (
  `Kode_kelas` varchar(10) NOT NULL,
  `Nama_kelas` varchar(50) DEFAULT NULL,
  `group_kelas` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_kelas`
--

INSERT INTO `tbl_kelas` (`Kode_kelas`, `Nama_kelas`, `group_kelas`) VALUES
('KLS-1', 'KELAS X TKJ 1', 'Kelas 1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_pembayaran`
--

CREATE TABLE `tbl_pembayaran` (
  `Kode_bayar` int(10) NOT NULL,
  `Nama_pembayaran` varchar(50) DEFAULT NULL,
  `Biaya` double DEFAULT NULL,
  `group_kelas` varchar(50) DEFAULT NULL,
  `Periode` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 9216 kB; InnoDB free: 9216 kB';

--
-- Dumping data untuk tabel `tbl_pembayaran`
--

INSERT INTO `tbl_pembayaran` (`Kode_bayar`, `Nama_pembayaran`, `Biaya`, `group_kelas`, `Periode`) VALUES
(1, 'DAFTAR ULANG ', 100000, 'Kelas 1', 'TAPEL 2021/2022'),
(2, 'SPP JULI', 150000, 'Kelas 1', 'TAPEL 2021/2022'),
(3, 'SPP AGUSTUS', 150000, 'Kelas 1', 'TAPEL 2021/2022'),
(4, 'SPP SEPTEMBER', 150000, 'Kelas 1', 'TAPEL 2021/2022'),
(5, 'SPP OKTOBER', 150000, 'Kelas 1', 'TAPEL 2021/2022'),
(6, 'SPP NOVEMBER', 150000, 'Kelas 1', 'TAPEL 2021/2022');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_periode`
--

CREATE TABLE `tbl_periode` (
  `Periode` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_periode`
--

INSERT INTO `tbl_periode` (`Periode`) VALUES
('TAPEL 2021/2022');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_setupkelas`
--

CREATE TABLE `tbl_setupkelas` (
  `Periode` varchar(50) NOT NULL,
  `Kode_siswa` varchar(10) NOT NULL,
  `Kode_Kelas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_setupkelas`
--

INSERT INTO `tbl_setupkelas` (`Periode`, `Kode_siswa`, `Kode_Kelas`) VALUES
('TAPEL 2021/2022', '1', 'KLS-1');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_siswa`
--

CREATE TABLE `tbl_siswa` (
  `Kode_siswa` int(10) NOT NULL,
  `Nama_siswa` varchar(50) DEFAULT NULL,
  `Alamat` varchar(255) DEFAULT NULL,
  `No_telepon` varchar(15) DEFAULT NULL,
  `nomor_induk` varchar(25) DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_siswa`
--

INSERT INTO `tbl_siswa` (`Kode_siswa`, `Nama_siswa`, `Alamat`, `No_telepon`, `nomor_induk`, `Status`) VALUES
(1, 'Yogi', '', '', '', 'aktif');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `no_faktur` varchar(20) NOT NULL,
  `Tanggal` date DEFAULT NULL,
  `periode` varchar(50) DEFAULT NULL,
  `Kode_siswa` varchar(10) DEFAULT NULL,
  `Kode_kelas` varchar(10) DEFAULT NULL,
  `Jumlah_bayar` double DEFAULT NULL,
  `user` varchar(10) DEFAULT NULL,
  `kembalian` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_transaksi`
--

INSERT INTO `tbl_transaksi` (`no_faktur`, `Tanggal`, `periode`, `Kode_siswa`, `Kode_kelas`, `Jumlah_bayar`, `user`, `kembalian`) VALUES
('Auto Fill', '2021-01-05', 'TAPEL 2021/2022', '1', 'KLS-1', 400000, 'Hry', 0),
('Kwi-001', '2021-01-05', 'TAPEL 2021/2022', '1', 'KLS-1', 500000, 'Hry', 50000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_user`
--

CREATE TABLE `tbl_user` (
  `Kode_user` varchar(10) NOT NULL,
  `Nama_user` varchar(50) DEFAULT NULL,
  `Pass` varchar(50) DEFAULT NULL,
  `Telephon` varchar(15) DEFAULT NULL,
  `level` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_user`
--

INSERT INTO `tbl_user` (`Kode_user`, `Nama_user`, `Pass`, `Telephon`, `level`) VALUES
('U-01', 'Widi', '1234', '082331041324', 'petugas'),
('U-02', 'Hry', 'hari1258', '085646753245', 'admin'),
('U-05', 'ITA', '132935', '', 'petugas'),
('U-06', 'Tuty', '688197', '', 'petugas'),
('U-07', 'Ayu', '333', '085755075582', 'petugas');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_kelas`
--
ALTER TABLE `tbl_kelas`
  ADD PRIMARY KEY (`Kode_kelas`);

--
-- Indeks untuk tabel `tbl_pembayaran`
--
ALTER TABLE `tbl_pembayaran`
  ADD PRIMARY KEY (`Kode_bayar`);

--
-- Indeks untuk tabel `tbl_periode`
--
ALTER TABLE `tbl_periode`
  ADD PRIMARY KEY (`Periode`);

--
-- Indeks untuk tabel `tbl_setupkelas`
--
ALTER TABLE `tbl_setupkelas`
  ADD PRIMARY KEY (`Kode_siswa`,`Periode`,`Kode_Kelas`);

--
-- Indeks untuk tabel `tbl_siswa`
--
ALTER TABLE `tbl_siswa`
  ADD PRIMARY KEY (`Kode_siswa`);

--
-- Indeks untuk tabel `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD PRIMARY KEY (`no_faktur`);

--
-- Indeks untuk tabel `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`Kode_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

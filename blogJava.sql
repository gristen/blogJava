-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Окт 27 2023 г., 16:27
-- Версия сервера: 5.6.51
-- Версия PHP: 8.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `blogJava`
--

-- --------------------------------------------------------

--
-- Структура таблицы `posts`
--

CREATE TABLE `posts` (
  `id_posts` bigint(20) NOT NULL,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `posts`
--

INSERT INTO `posts` (`id_posts`, `content`, `title`, `id_user`) VALUES
(9, 'Тестовый контент', 'Тестовое название', 5);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id_user` bigint(20) NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id_user`, `password`, `username`) VALUES
(1, '$2a$08$70lmAVAgOfMnUJvyaBka9O.bXI3XBNG7Ut6cpfxgkENfopl.ZWMGW', 'name'),
(2, '$2a$08$hg2boZkgRDdQJ1al72fAs.08G6xIYjP1eFAT10UhHgTLHO2ntbiQm', 'username'),
(3, '$2a$08$7KzuytE3kiCZcDaZKMFycupVoroKyeHLczW/6OJtUT2SdonYrkM6u', 'test1'),
(4, '$2a$08$echb/6PVE55cowCzfQJ/aOTglekfQ4uzxRV6GH9qQftftM0Jr.Q/G', 'test2'),
(5, '$2a$08$YJZCpIIdDo9bUUxqRv6v5e2E6DN22FIbamxdRN1dvbRThfSy3/MD.', 'admin');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_USER'),
(3, 'ROLE_USER'),
(4, 'ROLE_USER'),
(5, 'ROLE_ADMIN');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id_posts`),
  ADD KEY `FKi39p5vj96ak6nrx3k8kswyr8k` (`id_user`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `posts`
--
ALTER TABLE `posts`
  MODIFY `id_posts` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `FKi39p5vj96ak6nrx3k8kswyr8k` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

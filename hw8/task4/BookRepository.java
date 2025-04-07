public BookRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS books ("
            + "id SERIAL PRIMARY KEY, "
            + "Название VARCHAR(255) NOT NULL, "
            + "Автор VARCHAR(255) NOT NULL, "
            + "\"Год выпуска\" INTEGER, "
            + "Издательство VARCHAR(255))");
}

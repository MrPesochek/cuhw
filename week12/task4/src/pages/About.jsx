import React, { useContext } from 'react';
import { ThemeContext } from '../context/ThemeContext';
import { Link } from 'react-router-dom';

export function About() {
  const { theme, toggle } = useContext(ThemeContext);

  return (
    <div className={theme}>
      <h1>О нас</h1>
      <button onClick={toggle}>
        Переключить на {theme === 'light' ? 'тёмную' : 'светлую'} тему
      </button>
      <nav>
        <Link to="/">Главная</Link>
      </nav>
    </div>
  );
}

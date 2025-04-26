import React, { useState, useEffect } from 'react';

export function TimeDisplay({ format }) {
  const [now, setNow] = useState(new Date());

  useEffect(() => {
    const timerId = setInterval(() => setNow(new Date()), 1000);
    return () => clearInterval(timerId);
  }, []);

  const options = {
    hour: '2-digit',
    minute: '2-digit',
    second: '2-digit',
    hour12: format === '12-hour',
  };

  return (
    <div>
      <h2>Формат: {format === '12-hour' ? '12-часовой' : '24-часовой'}</h2>
      <p>{now.toLocaleTimeString([], options)}</p>
    </div>
  );
}

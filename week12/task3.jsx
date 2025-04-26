import React, { useState } from 'react';

export function TestCard() {
  const question = "Какой язык используется для построения интерфейсов в React?";
  const options = [
    { id: 1, text: "JavaScript", isCorrect: true },
    { id: 2, text: "Python",    isCorrect: false },
    { id: 3, text: "Ruby",      isCorrect: false },
    { id: 4, text: "C++",       isCorrect: false },
  ];

  const [selectedId, setSelectedId] = useState(null);

  const handleSelect = id => {
    if (selectedId === null) {
      setSelectedId(id);
    }
  };

  return (
    <div>
      <h3>{question}</h3>
      <ul style={{ listStyle: 'none', padding: 0 }}>
        {options.map(opt => (
          <li key={opt.id} style={{ margin: '0.5em 0' }}>
            <button onClick={() => handleSelect(opt.id)} disabled={selectedId !== null}>
              {opt.text}
            </button>
            {selectedId === opt.id && (
              <span style={{ marginLeft: '0.5em' }}>
                {opt.isCorrect ? 'Правильно' : 'Неправильно'}
              </span>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
}

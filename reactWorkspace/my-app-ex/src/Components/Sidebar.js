import React from 'react';

function Sidebar() {
  return (
    <aside style={sidebarStyle}>
      <h3 style={headingStyle}>Categories</h3>
      <ul style={listStyle}>
        <li style={listItemStyle}>Electronics</li>
        <li style={listItemStyle}>Fashion</li>
      </ul>
    </aside>
  );
}

const sidebarStyle = {
  padding: '20px',
  backgroundColor: '#f8f9fa',
  width: '250px',
  borderRight: '1px solid #ddd',
};

const headingStyle = {
  fontSize: '18px',
  marginBottom: '10px',
};

const listStyle = {
  listStyleType: 'none', // removes default bullet points
  padding: '0',
};

const listItemStyle = {
  padding: '10px 0',
  borderBottom: '1px solid #ddd',
  cursor: 'pointer',
  color: '#007bff',
};

export default Sidebar;

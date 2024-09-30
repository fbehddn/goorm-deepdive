import React from 'react';

function Header() {
  const headerStyle = {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: '20px',
    backgroundColor: '#343a40',
    color: 'white',
  };

  const logoStyle = {
    fontSize: '24px',
    fontWeight: 'bold',
  };

  const navStyle = {
    display: 'flex',
    gap: '20px',
  };

  const linkStyle = {
    color: 'white',
    textDecoration: 'none',
    fontSize: '16px',
  };

  const linkHoverStyle = {
    textDecoration: 'underline',
  };

  return (
    <header style={headerStyle}>
      <div style={logoStyle}>MyShop</div>
      <nav style={navStyle}>
        <ul style={{ listStyle: 'none', display: 'flex', gap: '20px', margin: 0, padding: 0 }}>
          <li><a href="#home" style={linkStyle}>Home</a></li>
          <li><a href="#shop" style={linkStyle}>Shop</a></li>
          <li><a href="#about" style={linkStyle}>About Us</a></li>
          <li><a href="#contact" style={linkStyle}>Contact</a></li>
          <li><a href="#cart" style={linkStyle}>Cart</a></li>
        </ul>
      </nav>
    </header>
  );
}

export default Header;

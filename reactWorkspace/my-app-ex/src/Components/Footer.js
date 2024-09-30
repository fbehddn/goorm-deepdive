import React from 'react';

function Footer() {
  const footerStyle = {
    backgroundColor: '#343a40',
    color: 'white',
    padding: '40px 20px',
    textAlign: 'center',
  };

  const sectionsStyle = {
    display: 'flex',
    justifyContent: 'space-around',
    marginBottom: '20px',
  };

  const columnStyle = {
    flex: 1,
    maxWidth: '200px',
  };

  const headingStyle = {
    fontSize: '18px',
    marginBottom: '10px',
  };

  const listStyle = {
    listStyle: 'none',
    padding: 0,
  };

  const listItemStyle = {
    margin: '8px 0',
  };

  const linkStyle = {
    color: 'white',
    textDecoration: 'none',
  };

  const footerBottomStyle = {
    borderTop: '1px solid #555',
    paddingTop: '10px',
  };

  return (
    <footer style={footerStyle}>
      <div style={sectionsStyle}>
        <div style={columnStyle}>
          <h3 style={headingStyle}>Customer Service</h3>
          <ul style={listStyle}>
            <li style={listItemStyle}><a href="#shipping" style={linkStyle}>Shipping Information</a></li>
          </ul>
        </div>
        <div style={columnStyle}>
          <h3 style={headingStyle}>About Us</h3>
          <ul style={listStyle}>
            <li style={listItemStyle}><a href="#about" style={linkStyle}>Our Story</a></li>
          </ul>
        </div>
        <div style={columnStyle}>
          <h3 style={headingStyle}>Follow Us</h3>
          <ul style={listStyle}>
            <li style={listItemStyle}><a href="#facebook" style={linkStyle}>Facebook</a></li>
          </ul>
        </div>
      </div>
      <div style={footerBottomStyle}>
        <p>&copy; 2024 MyShop. All Rights Reserved.</p>
      </div>
    </footer>
  );
}

export default Footer;

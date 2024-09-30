import React from 'react';

function FeaturedSection() {
  const sectionStyle = {
    padding: '40px',
    backgroundColor: '#f8f9fa',
    textAlign: 'center',
  };

  const gridStyle = {
    display: 'grid',
    gridTemplateColumns: 'repeat(3, 1fr)',
    gap: '20px',
  };

  const productStyle = {
    padding: '20px',
    backgroundColor: 'white',
    border: '1px solid #ddd',
    borderRadius: '8px',
    textAlign: 'center',
  };

  const imgStyle = {
    maxWidth: '50%',
    borderRadius: '8px',
  };

  const priceStyle = {
    fontSize: '16px',
    color: '#28a745',
    fontWeight: 'bold',
  };

  return (
    <section style={sectionStyle}>
      <h2>Featured Products</h2>
      <div style={gridStyle}>
        <div style={productStyle}>
          <img src="https://via.placeholder.com/150" alt="Product 1" style={imgStyle} />
          <h3>Product 1</h3>
          <p style={priceStyle}>$19.99</p>
        </div>
        <div style={productStyle}>
          <img src="https://via.placeholder.com/150" alt="Product 2" style={imgStyle} />
          <h3>Product 2</h3>
          <p style={priceStyle}>$29.99</p>
        </div>
        <div style={productStyle}>
          <img src="https://via.placeholder.com/150" alt="Product 3" style={imgStyle} />
          <h3>Product 3</h3>
          <p style={priceStyle}>$39.99</p>
        </div>
      </div>
    </section>
  );
}

export default FeaturedSection;

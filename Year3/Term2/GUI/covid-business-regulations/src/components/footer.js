import React from 'react';
import {
  MDBFooter,
  MDBContainer,
  MDBCol,
  MDBRow,
} from 'mdb-react-ui-kit';

export default function App() {
  return (
    <MDBFooter bgColor='primary' className='text-white text-center text-lg-left'>
      <MDBContainer className='p-4'>
        <MDBRow>
          <MDBCol lg='6' md='12' className='mb-4 mb-md-0'>
            <h5 className='text-uppercase'>Covid Business Regulations</h5>

            <p>
            The Covid Business Regulation app provides insights and guidance based on the latest government regulations to help you navigate the pandemic's impact on business operations.
            Stay updated with news, monitor developments with quick-stats, set reminders for important updates, and search through regulations with ease.
            While we strive to provide accurate and timely information, please ensure you consult with a legal professional for official advice, as our service is not liable for any legal wrongdoing or inaccuracies in the regulatory data.
            </p>
          </MDBCol>

          <MDBCol lg='3' md='6' className='mb-4 mb-md-0'>
            <h5 className='text-uppercase'>Useful Links</h5>

            <ul className='list-unstyled mb-0'>
              <li>
                <a href='#!' className='text-white'>
                  Government Website (Gov.UK)
                </a>
              </li>
              <li>
                <a href='#!' className='text-white'>
                  Company Policy
                </a>
              </li>
              <li>
                <a href='#!' className='text-white'>
                  Link 3
                </a>
              </li>
              <li>
                <a href='#!' className='text-white'>
                  Link 4
                </a>
              </li>
            </ul>
          </MDBCol>

          <MDBCol lg='3' md='6' className='mb-4 mb-md-0'>
            <h5 className='text-uppercase mb-0'>Contact us</h5>

            <ul className='list-unstyled'>
              <li>
                <a href='#!' className='text-white'>
                  Reach out to your Compliance Officer
                </a>
              </li>
              <li>
                <a href='#!' className='text-white'>
                  Give us Feedback
                </a>
              </li>
              <li>
                <a href='#!' className='text-white'>
                  Link 3
                </a>
              </li>
              <li>
                <a href='#!' className='text-white'>
                  Link 4
                </a>
              </li>
            </ul>
          </MDBCol>
        </MDBRow>
      </MDBContainer>

      <div className='text-center p-3' style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)' }}>
        &copy; {new Date().getFullYear()} Copyright:{' '}
        <a className='text-white' href='https://CompanyName.com/'>
          CompanyName
        </a>
      </div>
    </MDBFooter>
  );
}
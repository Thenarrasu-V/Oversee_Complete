import React, { useState, useEffect } from 'react';
import { Box, Typography, Grid, Paper, Card, CardContent, TextField, Button, Alert } from '@mui/material';
import { BarChart, Bar, XAxis, YAxis, Tooltip, CartesianGrid, Legend } from 'recharts';
import '../../styles/HR/HRDashboard.css';

const HRDashboard = () => {
    const [formData, setFormData] = useState({
        name: '',
        department: '',
        role: '',
    });

    const [errors, setErrors] = useState({});
    const [successMessage, setSuccessMessage] = useState('');
    const [showForm, setShowForm] = useState(false);

    useEffect(() => {
        const handleScroll = (event) => {
            if (window.scrollY > 100) {
                console.log('User scrolled down');
                // Add your scroll down logic here, e.g., scroll to a specific section
                // For example: window.scrollTo({ top: 500, behavior: 'smooth' });
            }
        };

        window.addEventListener('scroll', handleScroll);

        // Cleanup the event listener on component unmount
        return () => {
            window.removeEventListener('scroll', handleScroll);
        };
    }, []);

    const validateForm = () => {
        let formErrors = {};
        if (!formData.name) formErrors.name = 'Name is required';
        if (!formData.department) formErrors.department = 'Department is required';
        if (!formData.role) formErrors.role = 'Role is required';
        return formErrors;
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleFormSubmit = (e) => {
        e.preventDefault();
        const formErrors = validateForm();
        if (Object.keys(formErrors).length === 0) {
            setSuccessMessage('Employee created successfully!');
            setFormData({ name: '', department: '', role: '' });
            setErrors({});
        } else {
            setErrors(formErrors);
        }
    };

    // Sample static data for the chart
    const data = [
        { name: 'Jan', Sales: 4000 },
        { name: 'Feb', Sales: 3000 },
        { name: 'Mar', Sales: 2000 },
        { name: 'Apr', Sales: 2780 },
        { name: 'May', Sales: 1890 },
        { name: 'Jun', Sales: 2390 },
        { name: 'Jul', Sales: 3490 },
    ];

    return (
        <Box sx={{ display: 'flex', height: '100vh', overflow: 'hidden' }}>
            <Box sx={{ flexGrow: 1, padding: 3, overflowY: 'auto', maxHeight: '100vh' }}>
                <Grid container spacing={3}>
                    <Grid item xs={12}>
                        <Paper elevation={3} sx={{ padding: 3 }}>
                            <Typography variant="h4" align="center" gutterBottom color="black">
                                HR Dashboard
                            </Typography>
                        </Paper>
                    </Grid>

                    <Grid item xs={12} md={6}>
                        <Card elevation={3}>
                            <CardContent>
                                <Typography variant="h5" gutterBottom color="black">
                                    Employee Overview
                                </Typography>
                                <Typography variant="body1" color="black">
                                    Get a comprehensive view of all employees, their roles, and departments.
                                    Monitor performance metrics and stay updated on the latest employee statistics.
                                </Typography>
                            </CardContent>
                        </Card>
                    </Grid>

                    <Grid item xs={12} md={6}>
                        <Card elevation={3}>
                            <CardContent>
                                <Typography variant="h5" gutterBottom color="black">
                                    Leave Requests
                                </Typography>
                                <Typography variant="body1" color="black">
                                    You are responsible for approving or rejecting leave requests. Ensure that the workforce is well-balanced by managing the leave schedule effectively.
                                </Typography>
                            </CardContent>
                        </Card>
                    </Grid>

                    <Grid item xs={12} md={6}>
                        <Card elevation={3}>
                            <CardContent>
                                <Typography variant="h5" gutterBottom color="black">
                                    Create New Employee
                                </Typography>
                                <Typography variant="body1" color="black">
                                    Add new members to the team seamlessly. Fill in the necessary details and integrate them into the workforce quickly and efficiently.
                                </Typography>
                            </CardContent>
                        </Card>
                    </Grid>

                    <Grid item xs={12} md={6}>
                        <Card elevation={3}>
                            <CardContent>
                                <Typography variant="h5" gutterBottom color="black">
                                    Employee Feedback
                                </Typography>
                                <Typography variant="body1" color="black">
                                    Read and manage feedback from various employees. Use the insights to improve the workplace environment and boost employee satisfaction.
                                </Typography>
                            </CardContent>
                        </Card>
                    </Grid>

                    <Grid item xs={12}>
                        <Paper elevation={3} sx={{ padding: 3 }}>
                            <Typography variant="h6" gutterBottom color="black">
                                Employee Performance Overview
                            </Typography>
                            <Box sx={{ width: '100%', height: 400 }}>
                                <BarChart width={600} height={300} data={data}>
                                    <CartesianGrid strokeDasharray="3 3" />
                                    <XAxis dataKey="name" />
                                    <YAxis />
                                    <Tooltip />
                                    <Legend />
                                    <Bar dataKey="Sales" fill="#8884d8" />
                                </BarChart>
                            </Box>
                        </Paper>
                    </Grid>

                    <Grid item xs={12}>
                        {showForm && (
                            <Box component="form" sx={{ mt: 3 }} onSubmit={handleFormSubmit}>
                                <Paper elevation={3} sx={{ padding: 3 }}>
                                    <Grid container spacing={3}>
                                        <Grid item xs={12}>
                                            <TextField
                                                fullWidth
                                                label="Employee Name"
                                                name="name"
                                                value={formData.name}
                                                onChange={handleInputChange}
                                                error={Boolean(errors.name)}
                                                helperText={errors.name}
                                            />
                                        </Grid>
                                        <Grid item xs={12}>
                                            <TextField
                                                fullWidth
                                                label="Department"
                                                name="department"
                                                value={formData.department}
                                                onChange={handleInputChange}
                                                error={Boolean(errors.department)}
                                                helperText={errors.department}
                                            />
                                        </Grid>
                                        <Grid item xs={12}>
                                            <TextField
                                                fullWidth
                                                label="Role"
                                                name="role"
                                                value={formData.role}
                                                onChange={handleInputChange}
                                                error={Boolean(errors.role)}
                                                helperText={errors.role}
                                            />
                                        </Grid>
                                        {successMessage && (
                                            <Grid item xs={12}>
                                                <Alert severity="success">{successMessage}</Alert>
                                            </Grid>
                                        )}
                                        <Grid item xs={12}>
                                            <Button variant="contained" color="primary" type="submit">
                                                Create Employee
                                            </Button>
                                        </Grid>
                                    </Grid>
                                </Paper>
                            </Box>
                        )}
                    </Grid>
                </Grid>
            </Box>
        </Box>
    );
};

export default HRDashboard;

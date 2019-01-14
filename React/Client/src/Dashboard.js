import React from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';
import { GoogleLogout } from 'react-google-login';
import { withStyles } from '@material-ui/core/styles';
import CssBaseline from '@material-ui/core/CssBaseline';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import Badge from '@material-ui/core/Badge';
import MenuIcon from '@material-ui/icons/Menu';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import NotificationsIcon from '@material-ui/icons/Notifications';
import InputIcon from '@material-ui/icons/Input';
import { mainListItems, secondaryListItems } from './listItems';
import SimpleLineChart from './SimpleLineChart';
import SimpleTable from './SimpleTable';
import Switch from '@material-ui/core/Switch';
import Fab from '@material-ui/core/Fab';
import EditIcon from '@material-ui/icons/Edit';
import AddIcon from '@material-ui/icons/Add';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import FormDialog from './FormDialog';
import ReactDOM from 'react-dom';
import GoogleLogin from 'react-google-login';
import { Router, Route, Link, browserHistory, IndexRoute } from 'react-router';
import Button from '@material-ui/core/Button';




const drawerWidth = 240;

const styles = theme => ({
  root: {
    display: 'flex',
  },
  button: {
    margin: theme.spacing.unit,
  },
  
  toolbar: {
    paddingRight: 24, // keep right padding when drawer closed
  },
  toolbarIcon: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-end',
    padding: '0 8px',
    ...theme.mixins.toolbar,
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  appBarShift: {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  menuButton: {
    marginLeft: 12,
    marginRight: 36,
  },
  menuButtonHidden: {
    display: 'none',
  },
  title: {
    flexGrow: 1,
  },
  drawerPaper: {
    position: 'relative',
    whiteSpace: 'nowrap',
    width: drawerWidth,
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  drawerPaperClose: {
    overflowX: 'hidden',
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    width: theme.spacing.unit * 7,
    [theme.breakpoints.up('sm')]: {
      width: theme.spacing.unit * 9,
    },
  },
  appBarSpacer: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    padding: theme.spacing.unit * 3,
    height: '100vh',
    overflow: 'auto',
  },
  chartContainer: {
    marginLeft: -22,
  },
  tableContainer: {
    height: 320,
  },
  h5: {
    marginBottom: theme.spacing.unit * 2,
  },
});



class Dashboard extends React.Component {
  state = {
    open: false,
    isLoggedIn:false,
    data:[],
  };

  name="";

  formChild1(params) {
    this.setState({
      data : params
    })
  }

   responseGoogle = (response) => {
    console.log(response);
    console.log(response.w3.ig);
    this.name=response.w3.ig;
    this.setState({ isLoggedIn:true, });
    
  }
  
  
   logout=(response)=>{
    console.log(response);
    this.setState({ isLoggedIn:false, });
    
  }
  


  handleDrawerOpen = () => {
    this.setState({ open: true, });
  };

  handleDrawerClose = () => {
    this.setState({ open: false, });
  };

  render() {
    const { classes } = this.props;

    return (
      <div className={classes.root}>
        <CssBaseline />
        <AppBar
          position="absolute"
          className={classNames(classes.appBar, this.state.open && classes.appBarShift)}
        >
          <Toolbar disableGutters={!this.state.open} className={classes.toolbar}>
            <IconButton
              color="inherit"
              aria-label="Open drawer"
              onClick={this.handleDrawerOpen}
              className={classNames(
                classes.menuButton,
                this.state.open && classes.menuButtonHidden,
              )}
            >
              <MenuIcon />
            </IconButton>
            <Typography
              component="h1"
              variant="h6"
              color="inherit"
              noWrap
              className={classes.title}
            >
             Office Meals
            </Typography>
            { (this.state.isLoggedIn) &&
            (<p>Welcome {this.name}   </p>
    )}
            <pre>   </pre>
           <div>
          { (!this.state.isLoggedIn)?( <GoogleLogin
    clientId="223402443186-2o5sbj12p2hvvd5jqrhfe385lhorrpkd.apps.googleusercontent.com"
    buttonText="Login"
    onSuccess={this.responseGoogle}
    onFailure={this.responseGoogle}
  />):(
    <div>
    <GoogleLogout
      buttonText="Logout"
      onLogoutSuccess={this.logout}
    >
    </GoogleLogout>
    </div>
  )
  
}
           
  </div>

         
          </Toolbar>
        </AppBar>
        { (this.state.isLoggedIn) && (
        <Drawer
          variant="permanent"
          classes={{
            paper: classNames(classes.drawerPaper, !this.state.open && classes.drawerPaperClose),
          }}
          open={this.state.open}
        >
          <div className={classes.toolbarIcon}>
            <IconButton onClick={this.handleDrawerClose}>
              <ChevronLeftIcon />
            </IconButton>
          </div>
          <Divider />
          <List>{mainListItems}</List>
          <Divider />
          <List>{secondaryListItems}</List>
        </Drawer>
        )}
        { (this.state.isLoggedIn) && (
        <main className={classes.content}>
          <div className={classes.appBarSpacer} />
          <Typography variant="h4" gutterBottom component="h2">
          </Typography>
          <Typography component="div" className={classes.chartContainer}>

          </Typography>
          <Typography variant="h4" gutterBottom component="h2" align="left">
            Items List
          </Typography>
          
    
      <FormDialog callback={this.formChild1.bind(this)}/>
      
          <div className={classes.tableContainer}>
            <SimpleTable data={this.state.data}/>
            <Button variant="contained" color="secondary" className={classes.button}>Submit</Button>
          </div>
        </main>

        
       
          )
        }
      </div>
        
    );
    
  }
}

Dashboard.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(Dashboard);